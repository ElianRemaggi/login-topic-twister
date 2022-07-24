package com.example.model.repository

import com.example.model.Player
import com.example.model.repository.interfaces.IUserIDRepository
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.ServerApi
import com.mongodb.ServerApiVersion
import com.mongodb.client.MongoClients
import java.util.StringJoiner

class UserIDRepository : IUserIDRepository {
    private lateinit var Users : MutableList<String>

    constructor(){

       this.Users = this.GetUserRepository() as MutableList<String>
    }

    override fun GetUserRepository(): List<String> {
        try {
            val connectionString =
                ConnectionString("mongodb+srv://root:1234@topictwister.rbqoldd.mongodb.net/?retryWrites=true&w=majority")
            val settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(
                    ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build()
                )
                .build()
            val mongoClient = MongoClients.create(settings)
            val database = mongoClient.getDatabase("login")
            val collection = database.getCollection("users")

            val response = mutableListOf<String>()

            for(item in collection.find()){
                response.add(item.get("UserID") as String)
            }
            return response
        } catch (e: Exception) {
            println(e.message)
            throw e
        }
    }

     public fun GetUserIDList() : List<String>{
       return this.Users
       }
}
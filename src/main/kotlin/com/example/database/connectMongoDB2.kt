package com.example.database

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.ServerApi
import com.mongodb.ServerApiVersion
import com.mongodb.client.MongoClients


class connectMongoDB2 {
    fun connectTest(): Boolean {
        return try {
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

            println("------------------------------")
            for(item in collection.find()){
                println(item.toJson())
            }

            true
        } catch (e: Exception) {
            println(e.message)
            false
        }
    }
}
package com.example.database

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients

class connectMongoDB {
    fun connect(): Boolean {
        return try {
            val connectionString =
                ConnectionString("mongodb+srv://root:1234@topictwister.rbqoldd.mongodb.net/?retryWrites=true&w=majority")
            val settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build()
            val mongoClient = MongoClients.create(settings)
            val database = mongoClient.getDatabase("test")
            println("databaseResponse")
            println(database.listCollections())
            true
        } catch (e: Exception) {
            println(e.message)
            false
        }
    }
}
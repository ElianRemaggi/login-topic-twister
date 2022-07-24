package com.example.database

import com.example.database.*
import org.junit.Assert
import org.junit.Test

class connectMongoDBTest {
    @Test
    fun connectMongoDBSholdHitDatabase(){
        //Arrange

        var connection = connectMongoDB()
        var response : Boolean
        //Act
        response = connection.connect()
        //Assert
        Assert.assertTrue(response)
    }
}
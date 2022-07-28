package com.example.database

import com.example.database.*
import org.junit.Assert
import org.junit.Test

class connectMongoDBTest2 {
    @Test
    fun connectMongoDBSholdHitDatabase(){
        //Arrange

        var connection = connectMongoDB2()
        var response : Boolean
        //Act
        response = connection.connectTest()
        println("----->"+response)
        //Assert
        Assert.assertTrue(response)
    }
}
package com.example.model

import io.ktor.util.reflect.*
import org.junit.Assert
import org.junit.Test
//import org.junit.jupiter.api.Assertions.*
import kotlin.reflect.typeOf

internal class PlayerTest {


    @Test
    fun PlayerConstructorShouldInstantiateAPlayer() {
        //Arrange
        val player = Player("userId",true, PlayerData(1,"username", listOf<PowerUp>()))
        //Act
        //Assert
        Assert.assertTrue(player is Player)
    }

    @Test
    fun PlayerGetMethodsShouldReturnExpectedType() {
        //Arrange
        val player = Player("userId",true, PlayerData(1,"username", listOf<PowerUp>()))
        //Act
        //Assert
        Assert.assertTrue(player.getUserID() is String)
        Assert.assertTrue(player.getLookingForMatch() is Boolean)
        Assert.assertTrue(player.getPlayerData() is PlayerData)
    }


}
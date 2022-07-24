package com.example.model.repository

import com.example.model.Player
import com.example.model.PlayerData
import com.example.model.PowerUp
import com.example.model.repository.interfaces.IPlayerRepository
import io.ktor.util.reflect.*
import org.junit.Assert
import org.junit.Test
//import org.junit.jupiter.api.Assertions.*
import kotlin.reflect.typeOf

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner




@RunWith(MockitoJUnitRunner::class)
internal class PlayerRepositoryTests {

    @Mock
    lateinit var _playerRepository: IPlayerRepository

    @Test
    fun FindPlayerByIDShouldReturnAPlayer(){
        //Arrange
        _playerRepository = PlayerRepository()

        var player : Player?
        //Act
        player = _playerRepository.FindPlayerById("lgarcia")
        println("id "+player?.getUserID())

        //Assert
        Assert.assertEquals(player?.getPlayerData()?.getName(), "Luis")
    }

    /*
        fun FindPlayerByIDShouldReturnAPlayer(){
        //Arrange
        val elements = listOf(
            Player("lgarcia", false, PlayerData(1,"Luis",  listOf(PowerUp()))),
            Player("juan", false, PlayerData(2,"Elian",  listOf(PowerUp()))))

        Mockito.`when`(_playerRepository.GetPlayerRepository()).thenReturn(elements)
        _playerRepository = PlayerRepository()

        var player : Player?
        //Act
        player = _playerRepository.FindPlayerById("juan")
        println("id "+player?.getUserID())
        //Assert
        Assert.assertEquals(player?.getPlayerData()?.getName(), "Elian")
    }
     */

}
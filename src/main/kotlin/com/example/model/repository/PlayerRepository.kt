package com.example.model.repository

import com.example.model.Player
import com.example.model.PlayerData
import com.example.model.PowerUp
import com.example.model.repository.interfaces.IPlayerRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.util.reflect.*
import java.io.File
import java.io.IOException
import java.io.InputStream
import kotlin.reflect.typeOf

class PlayerRepository : IPlayerRepository {

    private lateinit var Players : MutableList<Player>

    constructor(){
        this.Players = this.GetPlayerRepository() as MutableList<Player>
    }

    override fun FindPlayerById(ID: String?): Player? {
        return this.Players.first { player -> player.getUserID() == ID }
    }


    override fun GetPlayerRepository(): List<Player?>? {

        //Get Data
        val path: String = "src/main/kotlin/com/example/data/players.json"
        val inputStream: InputStream = File(path).inputStream()
        val response = inputStream.bufferedReader().use { it.readText() }

        //Deserialize
        var gson = Gson()
        var playerList :MutableList<Player>
        val itemType = object : TypeToken<MutableList<Player>>() {}.type
        playerList = gson.fromJson(response, itemType  )

        return playerList
    }

    override fun GetAllPlayers(): List<Player?>? {
        return this.Players
    }


    override fun AddWinByID(ID: String) {

            var player = this.Players.first { player -> player.getUserID() == ID  }
            this.Players.remove(player)
            var playerData = player.getPlayerData()
            playerData.setWinsAmount(playerData.getWinsAmount()+1)
            player.setPlayerData(playerData)
            this.Players.add(player)
            var gson = Gson()
            var path = "src/main/kotlin/com/example/data/players.json"
            val myFile = File(path)
            myFile.writeText(gson.toJson(this.Players))

    }

   /* override fun UpdatePlayerData(playerId: String?, playerData: PlayerData?) {
        TODO("Not yet implemented")
    }

      override fun FindPlayersLookingForMatch(): List<Player?>? {
        TODO("Not yet implemented")
    }

    override fun UpdatePlayerLookingForMatch(playerID: String?, lookingForMatch: Boolean?) {
        TODO("Not yet implemented")
    }

    */

}
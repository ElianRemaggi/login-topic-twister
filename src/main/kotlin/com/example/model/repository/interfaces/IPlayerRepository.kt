package com.example.model.repository.interfaces

import com.example.model.Player
import com.example.model.PlayerData

interface IPlayerRepository {
    fun FindPlayerById(ID: String?): Player?
    //fun FindPlayersLookingForMatch(): List<Player?>?
    //fun UpdatePlayerData(playerId: String?, playerData: PlayerData?)
    fun GetPlayerRepository(): List<Player?>?
    fun GetAllPlayers(): List<Player?>?
    //fun UpdatePlayerLookingForMatch(playerID: String?, lookingForMatch: Boolean?)
    fun AddWinByID(ID: String)
}

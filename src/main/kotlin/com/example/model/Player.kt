package com.example.model

class Player {

    private var UserID: String
    private var LookingForMatch: Boolean
    private var PlayerData: PlayerData


    constructor(_userID: String, _lookingForMatch: Boolean, _playerData: PlayerData) {
        this.UserID = _userID
        this.LookingForMatch = _lookingForMatch
        this.PlayerData = _playerData
    }

    fun getUserID(): String {
        return this.UserID
    }

    fun getPlayerData(): PlayerData {
        return this.PlayerData
    }

    fun getLookingForMatch(): Boolean{
        return this.LookingForMatch
    }

    fun setPlayerData(playerData: PlayerData){
        this.PlayerData = playerData
    }

}

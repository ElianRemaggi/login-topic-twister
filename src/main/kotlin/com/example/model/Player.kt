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
    constructor(_userID: String){
        this.UserID = _userID
        this.LookingForMatch = true
        this.PlayerData = PlayerData(1,"")
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

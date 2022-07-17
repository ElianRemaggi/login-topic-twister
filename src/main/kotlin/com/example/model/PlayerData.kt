package com.example.model

class PlayerData {

    private var WinsAmount: Int
    private var Name : String
    private var PowerUps : List<PowerUp>

    constructor(WinsAmount: Int, Name: String, PowerUps: List<PowerUp>) {
        this.WinsAmount = WinsAmount
        this.Name = Name
        this.PowerUps = PowerUps
    }

    constructor(WinsAmount: Int, Name: String){
    this.WinsAmount = WinsAmount
        this.Name = Name
        this.PowerUps = listOf<PowerUp>()
    }

    fun getWinsAmount(): Int{
        return this.WinsAmount
    }

    fun setWinsAmount(winsAmount : Int){
        this.WinsAmount = winsAmount
    }

    fun  getName(): String{
        return this.Name
    }

}

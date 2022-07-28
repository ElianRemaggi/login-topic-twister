package com.example.useCases

import com.example.model.PowerUp
import com.example.model.repository.UserIDRepository
import com.example.model.repository.interfaces.IUserIDRepository
import kotlin.concurrent.thread

class ValidateUserID {

    lateinit var userIDRepository : IUserIDRepository

    constructor(userIDRepository: UserIDRepository) {
        this.userIDRepository = userIDRepository
    }

    fun Execute( solicitedID : String ) : Boolean{
        try{
            userIDRepository = UserIDRepository()
            var userIdList =  userIDRepository.GetUserRepository()
            for(user in userIdList){
                if(solicitedID == user){
                    return true
                }
            }
            return false

        }catch (e: Exception){
            throw e;
        }
    }
}
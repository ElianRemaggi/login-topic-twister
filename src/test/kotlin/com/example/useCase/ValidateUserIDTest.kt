package com.example.useCase

import com.example.model.repository.UserIDRepository
import com.example.model.repository.interfaces.IUserIDRepository
import com.example.useCases.ValidateUserID
import org.junit.Assert
import org.junit.Test


class ValidateUserIDTest {


    @Test
    fun ExecuteShouldReturnTrueIfSolicitedIdIsInTheList() {
        //Arrange
        lateinit var userIDRepository : IUserIDRepository
        userIDRepository = UserIDRepository()
        val validateUserID = ValidateUserID(userIDRepository)
        var response : Boolean
        //Act
        response = validateUserID.Execute("remaggi");
        //Accert
        Assert.assertTrue(response)
    }
    @Test
    fun ExecuteShouldReturnFalseIfSolicitedIdIsNotInTheRepository(){
        lateinit var userIDRepository : IUserIDRepository
        userIDRepository = UserIDRepository()
        val validateUserID = ValidateUserID(userIDRepository)
        var response : Boolean
        //Act
        response = validateUserID.Execute("saddsasdada");
        //Accert
        Assert.assertFalse(response)
    }


}
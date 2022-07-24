package com.example.model.repository


import org.junit.Assert
import org.junit.Test
import org.mockito.internal.matchers.Not
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

class UserIDRepositoryTest {
    @Test
    fun userIdRepositoryShouldContainItemsInUserIDList(){
        //Arrange
        var userIDRepository = UserIDRepository()
        var userIDList : MutableList<String>
        //Act
        userIDList = userIDRepository.GetUserIDList() as MutableList<String>
        //Assert
        Assert.assertTrue(userIDList.count() > 0)
    }
}
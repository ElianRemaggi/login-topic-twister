package com.example.plugins


import com.example.model.Player
import com.example.model.PlayerData
import com.example.model.repository.PlayerRepository
import com.example.model.repository.UserIDRepository
import com.example.model.repository.interfaces.IPlayerRepository
import com.example.model.repository.interfaces.IUserIDRepository
import com.example.useCases.ValidateUserID
import com.google.gson.Gson
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import java.io.IOException


fun Application.configureRouting(

){
    val playerRepository : IPlayerRepository
    playerRepository = PlayerRepository()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/GetPlayerByID/{id}"){
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id", status = HttpStatusCode.BadRequest
            )
            var gson = Gson()
            playerRepository.FindPlayerById(id.toString())?.let { it -> call.respondText(gson.toJson(it)) }
        }

        get("/GetAllPlayers"){
            var gson = Gson()
            call.respondText( gson.toJson(playerRepository.GetAllPlayers()))
        }
        get("/GetPlayerByIDMongo/{id}"){
            try {
                val id = call.parameters["id"] ?: return@get call.respondText(
                    "Missing or malformed id", status = HttpStatusCode.BadRequest
                )
                var gson = Gson()
                var userIDRepository : IUserIDRepository
                userIDRepository = UserIDRepository()

                var validateUserID = ValidateUserID(userIDRepository)

                if(validateUserID.Execute(id)){
                    val player = Player(id)
                    call.respondText(gson.toJson(player))
                }
                call.respondText("UserID Incorrecta")
            } catch (e: java.lang.Exception){
                throw (e)
            }

        }
    /*
        get("/response"){
            var gson = Gson()
            val respuesta = "Texto codificado en servicio"
            call.respondText( gson.toJson(respuesta))
        }

        get("/AddWinByID/{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id", status = HttpStatusCode.BadRequest
            )
            try {
                playerRepository.AddWinByID(id)
                call.respondText("Ok")
            }
            catch (e : IOException){
                println(e.message)
            }
        }*/
    }
}
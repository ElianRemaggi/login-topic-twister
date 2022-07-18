package com.example.plugins


import com.example.model.Player
import com.example.model.PlayerData
import com.example.model.repository.PlayerRepository
import com.example.model.repository.interfaces.IPlayerRepository
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
        get("/GetWorldBestPlayer"){
            val player = Player("Elian",true, PlayerData(1,"elian"));
            var gson = Gson()
            var jsonString = gson.toJson(player)
            call.respondText(jsonString)
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
        get("/response"){
            var gson = Gson()
            val respuesta = "Texto codificado en servicio"
            call.respondText( gson.toJson(respuesta))
        }

        get("/AddWinByID/{id}") {
            val id = call.parameters["id"] ?: return@post call.respondText(
                "Missing or malformed id", status = HttpStatusCode.BadRequest
            )
            try {
                playerRepository.AddWinByID(id)
                call.respondText("Ok")
            }
            catch (e : IOException){
                println(e.message)
            }
        }
    }
}

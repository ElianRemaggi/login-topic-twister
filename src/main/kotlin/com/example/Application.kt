package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.application.*

fun main() {
    //embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
//embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
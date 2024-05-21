package api

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient {
    install(ContentNegotiation) {
        // Configure content negotiation here
        json(
            contentType = ContentType.Application.Json,
            json = Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            }
        )
    }
}
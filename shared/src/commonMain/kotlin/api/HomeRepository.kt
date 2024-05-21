package api

import data.RandomUsersApiResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow

class HomeRepository {

    private suspend fun getRandomUsers():RandomUsersApiResponse{
        val result = httpClient.get("https://randomuser.me/api/?seed=abc&results=1&page=1")
        return result.body() as RandomUsersApiResponse
    }

    fun getUsers() = flow {
        emit(getRandomUsers().results)
    }

    suspend fun getMoreUsers() = getRandomUsers().results
}
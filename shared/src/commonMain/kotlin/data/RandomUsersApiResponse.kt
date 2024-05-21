package data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUsersApiResponse(
    @SerialName("info")
    val info: Info?,
    @SerialName("results")
    val results: List<RandomUser> = emptyList()
) {
    @Serializable
    data class Info(
        @SerialName("page")
        val page: Int?,
        @SerialName("results")
        val results: Int?,
        @SerialName("seed")
        val seed: String?,
        @SerialName("version")
        val version: String?
    )
}
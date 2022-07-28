package me.dio.app_repositories.data.services

import me.dio.app_repositories.data.model.Repos
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubServices {
    @GET("user/{user}repos")
    suspend fun listRepositories(@Path("user")user:String):List<Repos>
}
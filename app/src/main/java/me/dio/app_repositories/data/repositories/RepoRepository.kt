package me.dio.app_repositories.data.repositories

import kotlinx.coroutines.flow.Flow
import me.dio.app_repositories.data.model.Repos
import kotlinx.coroutines.flow.flow


interface RepoRepository {
    suspend fun listRepositories (user:String): Flow<List<Repos>>
}

interface flow<T> {

}
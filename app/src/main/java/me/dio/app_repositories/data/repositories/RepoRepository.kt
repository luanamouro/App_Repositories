package me.dio.app_repositories.data.repositories

import me.dio.app_repositories.data.model.Repos
import kotlinx.coroutines.flow.flow


interface RepoRepository {
    suspend fun listRepositories (user:String): flow<List<Repos>>
    abstract fun enit(repoList: List<Repos>)
}

interface flow<T> {

}

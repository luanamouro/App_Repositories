package me.dio.app_repositories.data.repositories


import kotlinx.coroutines.flow.flow
import me.dio.app_repositories.data.model.Repos
import me.dio.app_repositories.data.services.GitHubServices

class RepoRepositoryImpl(private val services: GitHubServices): RepoRepository {
    override suspend fun listRepositories (user: String)= flow<List<Repos>> {
        val repoList = services.listRepositories(user)
        enit(repoList)
    }

    override fun enit(repoList: List<Repos>) {
        TODO("Not yet implemented")
    }
}
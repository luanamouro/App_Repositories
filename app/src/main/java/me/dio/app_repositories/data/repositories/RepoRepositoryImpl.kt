package me.dio.app_repositories.data.repositories


import kotlinx.coroutines.flow.flow
import me.dio.app_repositories.data.model.Repos
import me.dio.app_repositories.data.services.GitHubServices
import retrofit2.HttpException
import android.os.RemoteException as RemoteException

class RepoRepositoryImpl(private val service: GitHubServices) : RepoRepository {

    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possivel fazer a busca no momento!")
        }
    }
}
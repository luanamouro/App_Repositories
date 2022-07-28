package me.dio.app_repositories.data.repositories


import kotlinx.coroutines.flow.flow
import me.dio.app_repositories.data.model.Repos
import me.dio.app_repositories.data.services.GitHubServices
import retrofit2.HttpException
import android.os.RemoteException as RemoteException

class RepoRepositoryImpl(private val services: GitHubServices): RepoRepository {
    override suspend fun listRepositories (user: String)= flow<List<Repos>> {
        try{
            val repoList = services.listRepositories(user)
            enit(repoList)
        } catch(ex:HttpException){
            throw RemoteException(ex.message ?: "Não foi possível executar a busca no momento.")
        }
    }

    val repoList = services.listRepositories(user)
    enit(repoList)
    }
}
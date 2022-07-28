package me.dio.app_repositories.domain

import kotlinx.coroutines.flow.Flow
import me.dio.app_repositories.core.UseCase
import me.dio.app_repositories.data.model.Repos
import me.dio.app_repositories.data.repositories.RepoRepository
import java.lang.reflect.Parameter

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
) : UseCase<String, List<Repos>>() {

    override suspend fun execute(param: String): Flow<List<Repos>> {
        return repository.listRepositories(param)
    }
}
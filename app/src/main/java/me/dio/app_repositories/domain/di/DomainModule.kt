package me.dio.app_repositories.domain.di

import com.google.android.datatransport.runtime.dagger.Module
import me.dio.app_repositories.data.di.DataModule
import me.dio.app_repositories.domain.ListUserRepositoriesUseCase

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule() = Module {
        return module {
            factory { ListUserRepositoriesUseCase(get()) }
        }

}
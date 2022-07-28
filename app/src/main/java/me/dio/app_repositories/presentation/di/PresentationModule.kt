package me.dio.app_repositories.presentation.di

import com.google.android.datatransport.runtime.dagger.Module
import me.dio.app_repositories.domain.ListUserRepositoriesUseCase
import me.dio.app_repositories.presentation.MainViewModel

object PresentationModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule() = Module {
        return module {
            viewModel { MainViewModel(get()) }
        }
    }
}
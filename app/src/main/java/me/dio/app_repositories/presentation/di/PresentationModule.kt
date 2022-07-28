package me.dio.app_repositories.presentation.di

import com.google.android.datatransport.runtime.dagger.Module
import me.dio.app_repositories.domain.ListUserRepositoriesUseCase
import me.dio.app_repositories.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object PresentationModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule(): org.koin.core.module.Module {
        return module {
            viewModel { MainViewModel(get()) }
        }
    }
}
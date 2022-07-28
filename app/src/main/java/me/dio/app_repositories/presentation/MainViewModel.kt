package me.dio.app_repositories.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import me.dio.app_repositories.data.model.Repos
import me.dio.app_repositories.domain.ListUserRepositoriesUseCase

class MainViewModel(
    private val listUserRepositoriesUseCase:ListUserRepositoriesUseCase
    ):ViewModel() {
        fun getRepoList(user:String){
            viewModelScope.launch {
                listUserRepositoriesUseCase.execute(user)
                    .onStart{

                    }
                    .catch{

                    }
                    .collect{

                    }
            }
        }
    sealed class State{
        object Loading:State()
        data class Success(val list: List<Repos>):State()
    }
}
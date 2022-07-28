package me.dio.app_repositories.data.di

import android.util.Log
import com.google.android.datatransport.runtime.dagger.Module
import me.dio.app_repositories.data.repositories.RepoRepository
import me.dio.app_repositories.data.repositories.RepoRepositoryImpl
import me.dio.app_repositories.data.services.GitHubServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


import retrofit2.Retrofit


object DataModule {

    private const val OK_HTTP = "OkHttp"

    fun load(){
        loadKoinModules(networkModules() + repoRepositoriesModule())

    }

    private fun loadKoinModules(any: Any) {

    }

    private fun networkModules(): Module {
        return module {
            single<Any> {
                val interceptor = HttpLoggingInterceptor {
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }

            single<Any> {
                GsonConverterFactory.create(GsonBuilder().create())
            }

            single {
                createService<GitHubServices>(get(), get())
            }
        } as Module
    }

    private fun get(): OkHttpClient {
        TODO("Not yet implemented")
    }

    private fun module(function: () -> Unit): Any {

    }

    private fun <T> single(function: () -> RepoRepositoryImpl) {

    }

    private fun repoRepositoriesModule(): Module {
        return module {
            single<RepoRepository>{RepoRepositoryImpl(get())}
        } as Module
    }

    private fun RepoRepositoryImpl(services: OkHttpClient): RepoRepositoryImpl {

    }


    private inline fun <reified T> createService(client: OkHttpClient, factory: GsonConverterFactory): T {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(factory)
            .build().create(T::class.java)
    }
}
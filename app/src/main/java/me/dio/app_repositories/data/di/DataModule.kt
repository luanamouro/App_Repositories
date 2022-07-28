package me.dio.app_repositories.data.di

import android.media.CamcorderProfile.get
import android.net.Network
import android.util.Log
import com.google.android.datatransport.runtime.dagger.Module
import me.dio.app_repositories.data.services.GitHubServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


import retrofit2.Retrofit


object DataModule {

    private const val OK_HTTP = "OkHttp"

    fun load(){
        loadKoinModules(networkModules())

    }
    
    private fun networkModules(): Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor {
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }

            single {
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

    private fun single(function: () -> OkHttpClient) {

    }

    private fun (): Module {
        return module {
            single<RepoRepository> { RepoRepositoryImpl(get()) }
        }
    }

    private inline fun <reified T> createService(client: OkHttpClient, factory: GsonConverterFactory): OkHttpClient {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(factory)
            .build().create(T::class.java)
    }
}
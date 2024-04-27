package ru.shalkoff.vsu_lesson8.practice.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.shalkoff.vsu_lesson8.practice.Const.BASE_URL

object RetrofitModule {

    val client: Retrofit = getRetrofitClient()

    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
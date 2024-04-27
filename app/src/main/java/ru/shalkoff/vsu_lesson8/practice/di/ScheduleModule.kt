package ru.shalkoff.vsu_lesson8.practice.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.shalkoff.vsu_lesson8.practice.ScheduleApiService
import ru.shalkoff.vsu_lesson8.practice.ScheduleRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ScheduleModule {

    @Provides
    @Singleton
    fun provideScheduleApiService(): ScheduleApiService {
        return RetrofitModule.client.create(
            ScheduleApiService::class.java
        )
    }

    @Provides
    @Singleton
    fun provideSchedulerRepository(
        apiService: ScheduleApiService
    ): ScheduleRepository {
        return ScheduleRepository(apiService)
    }
}
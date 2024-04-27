package ru.shalkoff.vsu_lesson8.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ExampleModule {

    @Provides
    fun provideHiltModel(): HiltModel {
        return HiltModel()
    }
}
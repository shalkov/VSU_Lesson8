package ru.shalkoff.vsu_lesson8.second_activity

import ru.shalkoff.vsu_lesson8.dagger2.DaggerUniverse

sealed class SecondUiState {

    data object InitScreen: SecondUiState()

    class ShowCurrentUniverse(
        val currentDaggerUniverse: DaggerUniverse? = null
    ) : SecondUiState()
}
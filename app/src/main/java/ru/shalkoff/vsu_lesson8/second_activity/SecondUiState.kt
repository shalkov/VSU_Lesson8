package ru.shalkoff.vsu_lesson8.second_activity

import ru.shalkoff.vsu_lesson6.models.RoutesResponse
import ru.shalkoff.vsu_lesson8.dagger2.DaggerUniverse

sealed class SecondUiState {

    data object InitScreen: SecondUiState()

    class ShowCurrentUniverse(
        val currentDaggerUniverse: DaggerUniverse? = null
    ) : SecondUiState()

    class ShowStartGameText(val text: String): SecondUiState()

    class ShowAllSchedule(
        val routesResponse: RoutesResponse
    ): SecondUiState()
}
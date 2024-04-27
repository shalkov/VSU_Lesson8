package ru.shalkoff.vsu_lesson8.second_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.shalkoff.vsu_lesson8.dagger2.DaggerUniverse
import ru.shalkoff.vsu_lesson8.hilt.HiltModel
import ru.shalkoff.vsu_lesson8.practice.ScheduleRepository
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val universe: DaggerUniverse,
    private val hiltModel: HiltModel,
    private val scheduleRepository: ScheduleRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<SecondUiState> = MutableStateFlow(
        SecondUiState.InitScreen
    )
    val uiState: StateFlow<SecondUiState> = _uiState.asStateFlow()

    init {
        val startText = hiltModel.getStartGameText()
        viewModelScope.launch {
            _uiState.tryEmit(
                SecondUiState.ShowStartGameText(
                    text = startText
                )
            )
        }
    }

    fun updateCurrentUniverse() {
        viewModelScope.launch {
            _uiState.tryEmit(
                SecondUiState.ShowCurrentUniverse(
                    currentDaggerUniverse = universe
                )
            )
        }
    }

    fun getAllSchedule() {
        viewModelScope.launch(Dispatchers.IO) {
            val routes = scheduleRepository.getAllSchedule()
            withContext(Dispatchers.Main) {
                _uiState.tryEmit(
                    SecondUiState.ShowAllSchedule(routes)
                )
            }
        }
    }
}
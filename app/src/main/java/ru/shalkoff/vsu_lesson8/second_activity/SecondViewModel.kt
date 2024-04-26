package ru.shalkoff.vsu_lesson8.second_activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.shalkoff.vsu_lesson8.dagger2.DaggerUniverse
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val universe: DaggerUniverse
) : ViewModel() {

    private val _uiState: MutableStateFlow<SecondUiState> = MutableStateFlow(
        SecondUiState.InitScreen
    )
    val uiState: StateFlow<SecondUiState> = _uiState.asStateFlow()

    fun updateCurrentUniverse() {
        viewModelScope.launch {
            _uiState.tryEmit(
                SecondUiState.ShowCurrentUniverse(
                    currentDaggerUniverse = universe
                )
            )
        }
    }
}
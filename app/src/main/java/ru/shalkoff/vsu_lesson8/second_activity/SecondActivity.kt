package ru.shalkoff.vsu_lesson8.second_activity

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.shalkoff.vsu_lesson8.R

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    private val viewModel: SecondViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        observeUpdateUiState()
        initListeners()
    }

    /**
     * Подписываемся на обновление состояния экрана
     */
    private fun observeUpdateUiState() {
        lifecycleScope.launch {
            viewModel.uiState.collect {
                when (it) {
                    is SecondUiState.InitScreen -> {
                        //Do nothing
                    }

                    is SecondUiState.ShowAllSchedule -> {
                        showToast(it.routesResponse.routes[0].routeNumber)
                    }

                    is SecondUiState.ShowStartGameText -> {
                        showToast(it.text)
                    }

                    is SecondUiState.ShowCurrentUniverse -> {
                        showToast("Хешкод: ${it.currentDaggerUniverse.hashCode()}")
                    }
                }
            }
        }
    }

    private fun initListeners() {
        findViewById<Button>(R.id.get_current_universe_btn).setOnClickListener {
            viewModel.updateCurrentUniverse()
        }
        findViewById<Button>(R.id.get_all_schedule_btn).setOnClickListener {
            viewModel.getAllSchedule()
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(
            this,
            text,
            Toast.LENGTH_SHORT
        ).show()
    }
}
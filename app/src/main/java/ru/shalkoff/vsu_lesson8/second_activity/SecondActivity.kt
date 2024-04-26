package ru.shalkoff.vsu_lesson8.second_activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.shalkoff.vsu_lesson8.R
import ru.shalkoff.vsu_lesson8.dagger2.DaggerUniverse
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var daggerUniverse: DaggerUniverse

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

        Log.d("SecondActivity", daggerUniverse.hashCode().toString())

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
                    is SecondUiState.ShowCurrentUniverse -> {
                        Toast.makeText(
                            this@SecondActivity,
                            "Хешкод: ${it.currentDaggerUniverse.hashCode()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun initListeners() {
        findViewById<Button>(R.id.get_current_universe_btn).setOnClickListener {
            viewModel.updateCurrentUniverse()
        }
    }
}
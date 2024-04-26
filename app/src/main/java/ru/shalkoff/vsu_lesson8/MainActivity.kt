package ru.shalkoff.vsu_lesson8

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.shalkoff.vsu_lesson8.dagger2.DaggerMainActivityComponent
import ru.shalkoff.vsu_lesson8.dagger2.DaggerUniverse
import ru.shalkoff.vsu_lesson8.second_activity.SecondActivity
import ru.shalkoff.vsu_lesson8.simple1.DependencyInjector
import ru.shalkoff.vsu_lesson8.simple1.DependencyProvider
import ru.shalkoff.vsu_lesson8.simple1.Universe
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var universe: Universe

    @Inject
    lateinit var daggerUniverse: DaggerUniverse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initListeners()

        DaggerMainActivityComponent.create().inject(this)

        val dependencyProvider = DependencyProvider()
        val dependencyInjector = DependencyInjector(
            dependencyProvider
        )
        dependencyInjector.injectDependencies(this)
    }

    private fun initListeners() {
        findViewById<Button>(R.id.open_second_activity_btn).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
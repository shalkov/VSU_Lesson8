package ru.shalkoff.vsu_lesson8.dagger2

import dagger.Component
import ru.shalkoff.vsu_lesson8.MainActivity

@Component
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}
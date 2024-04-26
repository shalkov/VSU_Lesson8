package ru.shalkoff.vsu_lesson8.simple1

import ru.shalkoff.vsu_lesson8.MainActivity

class DependencyInjector(
    private val dependencyProvider: IDependencyProvider
) {

    fun injectDependencies(mainActivity: MainActivity) {
        // Внедряем зависимости в MainActivity
        mainActivity.universe = dependencyProvider.getUniverse()
    }
}
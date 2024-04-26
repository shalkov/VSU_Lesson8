package ru.shalkoff.vsu_lesson8.dagger2

import javax.inject.Inject


data class DaggerUniverse @Inject constructor(private val galaxy: DaggerGalaxy)

data class DaggerGalaxy @Inject constructor(private val star: DaggerStar)

data class DaggerStar @Inject constructor(private val planet: DaggerPlanet)

data class DaggerPlanet(
    private val isHabitablePlanet: Boolean
) {
    @Inject constructor(): this(true)
}
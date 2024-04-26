package ru.shalkoff.vsu_lesson8.simple1

data class Universe(private val galaxy: Galaxy)

data class Galaxy(private val star: Star)

data class Star(private val planet: Planet)

data class Planet(
    private val isHabitablePlanet: Boolean = true
)
package ru.shalkoff.vsu_lesson8.simple1

interface IDependencyProvider {

    fun getUniverse(): Universe
    fun getGalaxy(): Galaxy
    fun getStar(): Star
    fun getPlanet(): Planet
}
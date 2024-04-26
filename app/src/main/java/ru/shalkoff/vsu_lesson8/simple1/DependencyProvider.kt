package ru.shalkoff.vsu_lesson8.simple1

class DependencyProvider: IDependencyProvider {

    override fun getUniverse(): Universe {
        return Universe(getGalaxy())
    }

    override fun getGalaxy(): Galaxy {
        return Galaxy(getStar())
    }

    override fun getStar(): Star {
        return Star(getPlanet())
    }

    override fun getPlanet(): Planet {
        return Planet()
    }
}
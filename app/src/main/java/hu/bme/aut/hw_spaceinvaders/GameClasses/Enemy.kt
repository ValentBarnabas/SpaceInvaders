package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas
import kotlin.random.Random

class Enemy constructor (x : Float) : SpaceObject() {

    init {
        this.setX(x)
    }

    override val imgIdx : Int = Random.nextInt(2,8)
    private val vel : Int = Random.nextInt(2,7)

    override fun CollidedWith(so: SpaceObject) {
        TODO("Not yet implemented")
    }

    override fun Step() {
//        TODO("Not yet implemented")
        this.setY(this.getY()+vel)
    }

    override fun Draw(canvas : Canvas) {
        TODO("Not yet implemented")
    }

    override fun HeightTooLow(game: Game) {
        game.changeScore(-10)
    }
}
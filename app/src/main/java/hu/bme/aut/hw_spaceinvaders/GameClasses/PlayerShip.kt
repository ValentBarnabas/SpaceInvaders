package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas

class PlayerShip() : SpaceObject() {

    override val imgIdx: Int = 0
    private var vel: Float = 0.0f

    override fun CollidedWith(so: SpaceObject) {
        TODO("Not yet implemented")
    }

    override fun Step() {
//        TODO("Not yet implemented")
    }

    override fun Draw(canvas : Canvas) {
        TODO("Not yet implemented")
    }

    fun setVel(vel : Float) {
        this.vel = vel
    }
}
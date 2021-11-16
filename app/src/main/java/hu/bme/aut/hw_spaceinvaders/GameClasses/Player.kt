package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas

class Player : SpaceObject() {

    private var alive : Boolean = false
    private var vel: Float = 0.0f

    init {
        alive = true
    }

    override fun CollidedWith(so: SpaceObject) {
        TODO("Not yet implemented")
    }

    override fun Step() {
        //TODO("Not yet implemented")
    }

    override fun Draw(canvas : Canvas) {
        TODO("Not yet implemented")
    }

    fun isAlive(): Boolean {
        return alive
    }

    fun setVel(vel : Float) {
        this.vel = vel
    }
}
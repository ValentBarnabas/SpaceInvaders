package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas

class Bullet() : SpaceObject() {

    override val imgIdx: Int = 1
    private var vel: Int = 0

    override fun CollidedWith(so: SpaceObject) {
        TODO("Not yet implemented")
    }

    override fun Step() {
//        TODO("Not yet implemented")
        this.setY(this.getY()-vel)
    }

    override fun Draw(canvas: Canvas) {
        TODO("Not yet implemented")
    }

    override fun HeightTooMuch(game : Game) {
        game.changeScore(-2)
    }

    fun setVel(vel : Int) {
        this.vel = vel
    }
}
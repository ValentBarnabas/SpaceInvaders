package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas
import android.util.Log

class Bullet() : SpaceObject() {

    override val imgIdx: Int = 1

    private var vel: Int = 0

    override fun CollidedWith(so: SpaceObject) {
        TODO("Not yet implemented")
    }

    override fun CheckBounds(width: Int, height: Int, game: Game) {
        if(this.getY() < 0)
            this.HeightTooLow(game)
    }

    override fun Step() {
//        TODO("Not yet implemented")
        this.setY(this.getY()-vel)
    }

    override fun Draw(canvas: Canvas) {
        TODO("Not yet implemented")
    }

    override fun HeightTooLow(game : Game) {
        game.removeSpaceObj(this)
        game.changeScore(-2)
    }

    fun setVel(vel : Int) {
        this.vel = vel
    }
}
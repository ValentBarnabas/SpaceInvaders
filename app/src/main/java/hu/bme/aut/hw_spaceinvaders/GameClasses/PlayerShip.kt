package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas
import android.util.Log

class PlayerShip() : SpaceObject() {

    override val imgIdx: Int = 0
    override fun CollideWith(so: SpaceObject) {
        so.CollidedWithSpec(this)
    }

    override fun CollidedWithSpec(e: Enemy) {
        Game.playerDied()
        super.CollidedWithSpec(e)
    }

    private var vel: Float = 0.0f
    private var shooting: Boolean = false;

    override fun CheckBounds(width: Int, height: Int, game: Game) {
        if (this.getX() < 0) {
            this.setX(0.toFloat())
        } else if (this.getX() > width) {
            this.setX(width.toFloat())
        }
    }

    override fun Step() {
        this.setX(this.getX() + vel)
        if(shooting) {
            Game.addShot(this.getX(), this.getY())
            shooting = false;
        }
    }

    override fun Draw(canvas : Canvas) {
        TODO("Not yet implemented")
    }

    fun setVel(vel : Float) {
        this.vel = vel
    }

    fun setShooting(isShooting: Boolean) {
        shooting = isShooting
    }

}
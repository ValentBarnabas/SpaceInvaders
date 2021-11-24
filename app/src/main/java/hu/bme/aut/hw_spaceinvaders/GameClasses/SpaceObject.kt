package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas
import android.util.Log
import hu.bme.aut.hw_spaceinvaders.Visuals.IDrawable
import hu.bme.aut.hw_spaceinvaders.GameLogic.Collision

abstract class SpaceObject () : ISteppable, IDrawable {

    public abstract val imgIdx : Int
    private var x : Float = 0.0f
    private var y : Float = 0.0f

    public fun CheckCollision(soList : MutableList<SpaceObject>, width: Int, height: Int) {
        Collision(this, soList, width, height)
    }

    public abstract fun CheckBounds(width: Int, height: Int, game: Game)

    public abstract fun CollideWith(so : SpaceObject)

    public open fun CollidedWithSpec(b: Bullet) {return;}
    public open fun CollidedWithSpec(e: Enemy) {return;}
    public open fun CollidedWithSpec(ps: PlayerShip) {return;}

    override fun Draw(canvas: Canvas) {

    }

    public open fun HeightTooMuch(game: Game) { return; }
    public open fun HeightTooLow(game: Game) { return; }


    fun getX() : Float {
        return x
    }
    fun getY() : Float {
        return y;
    }

    fun setX(x : Float) {
        this.x = x
    }
    fun setY(y : Float) {
        this.y = y
    }
}
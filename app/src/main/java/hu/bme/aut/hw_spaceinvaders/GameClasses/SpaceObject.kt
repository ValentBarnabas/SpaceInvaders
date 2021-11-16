package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas
import hu.bme.aut.hw_spaceinvaders.Visuals.IDrawable

abstract class SpaceObject () : ISteppable, IDrawable {

    public abstract val imgIdx : Int
    private var x : Float = 0.0f
    private var y : Float = 0.0f

    public fun CollideWith(so : SpaceObject) {
        so.CollidedWith(this)
    }

    public abstract fun CollidedWith(so: SpaceObject)

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
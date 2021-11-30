package hu.bme.aut.hw_spaceinvaders.GameClasses

import hu.bme.aut.hw_spaceinvaders.GameLogic.Collision
import hu.bme.aut.hw_spaceinvaders.Visuals.IObservable
import hu.bme.aut.hw_spaceinvaders.Visuals.ObservedData

abstract class SpaceObject () : ISteppable, IObservable {

    abstract val imgIdx : Int
    private var x : Float = 0.0f
    private var y : Float = 0.0f

    override fun getInfo() : ObservedData{
        return ObservedData(x.toInt(), y.toInt(), imgIdx)
    }

    fun CheckCollision(soList : MutableList<SpaceObject>, width: Int, height: Int) {
        Collision(this, soList, width, height)
    }

    abstract fun CheckBounds(width: Int, height: Int, spriteWidth: Int, game: Game)

    abstract fun CollideWith(so : SpaceObject)

    open fun CollidedWithSpec(b: Bullet) {return;}
    open fun CollidedWithSpec(e: Enemy) {return;}
    open fun CollidedWithSpec(ps: PlayerShip) {return;}

    open fun HeightTooMuch(game: Game) { return; }
    open fun HeightTooLow(game: Game) { return; }

    fun getX() : Float {
        return x
    }
    fun getY() : Float {
        return y
    }

    fun setX(x : Float) {
        this.x = x
    }
    fun setY(y : Float) {
        this.y = y
    }
}
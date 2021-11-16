package hu.bme.aut.hw_spaceinvaders.GameClasses

import hu.bme.aut.hw_spaceinvaders.Visuals.IDrawable

abstract class SpaceObject : ISteppable, IDrawable {
    private var x : Float = 0.0f
    private var y : Float = 0.0f

    public fun CollideWith(so : SpaceObject) {
        so.CollidedWith(this)
    }

    public abstract fun CollidedWith(so: SpaceObject)
}
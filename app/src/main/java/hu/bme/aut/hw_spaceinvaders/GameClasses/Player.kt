package hu.bme.aut.hw_spaceinvaders.GameClasses

class Player : Entity() {

    private var alive : Boolean = false
    private var vel: Float = 0.0f

    init {
        alive = true
    }

    override fun Step() {
        //TODO("Not yet implemented")
    }

    fun isAlive(): Boolean {
        return alive
    }

    fun setVel(vel : Float) {
        this.vel = vel
    }
}
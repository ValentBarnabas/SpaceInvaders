package hu.bme.aut.hw_spaceinvaders.GameClasses

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
    private var shooting: Boolean = false

    override fun CheckBounds(width: Int, height: Int, spriteWidth: Int, game: Game) {
        if (this.getX() < 0) {
            this.setX(0.toFloat())
        } else if (this.getX() > width-spriteWidth) {
            this.setX(width.toFloat()-spriteWidth)
        }
    }

    override fun Step() {
        this.setX(this.getX() + vel)
        if(shooting) {
            Game.addShot(this.getX(), this.getY())
            shooting = false
        }
    }

    fun setVel(vel : Float) {
        this.vel = vel
    }

    fun setShooting(isShooting: Boolean) {
        shooting = isShooting
    }

}
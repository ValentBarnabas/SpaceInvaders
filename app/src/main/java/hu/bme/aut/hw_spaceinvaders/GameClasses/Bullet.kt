package hu.bme.aut.hw_spaceinvaders.GameClasses

class Bullet() : SpaceObject() {

    override val imgIdx: Int = 1

    private var vel: Int = 0

    override fun CollideWith(so: SpaceObject) {
        so.CollidedWithSpec(this)
    }

    override fun CollidedWithSpec(e: Enemy) {
        Game.bulletHit(this, e)
        super.CollidedWithSpec(e)
    }

    override fun CheckBounds(width: Int, height: Int, spriteWidth: Int, game: Game) {
        if(this.getY() < 0-spriteWidth)
            this.HeightTooLow(game)
    }

    override fun Step() {
        this.setY(this.getY()-vel)
    }

    override fun HeightTooLow(game : Game) {
        game.removeSpaceObj(this)
        game.changeScore(-2)
    }

    fun setVel(vel : Int) {
        this.vel = vel
    }
}
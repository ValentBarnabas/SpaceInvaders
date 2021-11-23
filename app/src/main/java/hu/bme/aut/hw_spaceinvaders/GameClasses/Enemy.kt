package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.graphics.Canvas
import kotlin.random.Random

class Enemy constructor (x : Float) : SpaceObject() {

    init {
        this.setX(x)
    }

    override val imgIdx : Int = Random.nextInt(2,8)

    private val vel : Int = Random.nextInt(2,7)

    override fun CollidedWith(so: SpaceObject) {
        TODO("Not yet implemented")
    }

    override fun CheckBounds(width: Int, height: Int, game: Game) {
        if(this.getY() > height) {
            this.HeightTooMuch(game)
        }
    }

    override fun Step() {
//        TODO("Not yet implemented")
        this.setY(this.getY()+vel)
    }

    override fun Draw(canvas : Canvas) {
        TODO("Not yet implemented")
    }

    override fun HeightTooMuch(game: Game) {
        game.removeSpaceObj(this)
        game.changeScore(-10)
    }
}
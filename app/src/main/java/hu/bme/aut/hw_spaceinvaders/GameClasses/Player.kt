package hu.bme.aut.hw_spaceinvaders.GameClasses

class Player {

    public var playerShip : PlayerShip = PlayerShip()

    private var alive : Boolean = false
    private var score : Int = 0
    private var name : String = ""

    init {
        alive = true
    }

    fun getAlive(): Boolean {
        return alive
    }

    fun setAlive(alive: Boolean) {
        this.alive = alive
    }
    fun getScore() : Int {
        return score;
    }
    fun changeScore(amount : Int) {
        score += amount
    }

    fun setShooting(isShooting: Boolean) {
        playerShip.setShooting(true)
    }
}
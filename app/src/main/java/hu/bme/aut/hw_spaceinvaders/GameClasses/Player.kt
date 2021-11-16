package hu.bme.aut.hw_spaceinvaders.GameClasses

class Player {

    public var playerShip : PlayerShip = PlayerShip()

    private var alive : Boolean = false
    private var score : Int = 0
    private var name : String = ""

    init {
        alive = true
    }

    fun isAlive(): Boolean {
        return alive
    }
    fun getScore() : Int {
        return score;
    }
    fun setScore(amount : Int) {
        score += amount
    }
}
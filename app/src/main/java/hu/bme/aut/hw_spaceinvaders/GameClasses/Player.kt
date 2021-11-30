package hu.bme.aut.hw_spaceinvaders.GameClasses

class Player (name : String){

    var playerShip : PlayerShip = PlayerShip()

    private var alive : Boolean = false
    private var score : Int = 0
    private var name : String = "Anonymous"

    init {
        this.alive = true
        this.name = name
    }

    fun setShipX(x: Int) {
        playerShip.setX(x.toFloat())
    }

    fun setShipY(y: Int) {
        playerShip.setY(y.toFloat())
    }

    fun setShipVel(vel: Float) {
        playerShip.setVel(vel)
    }

    fun getAlive(): Boolean {
        return alive
    }

    fun setAlive(alive: Boolean) {
        this.alive = alive
    }

    fun getName() : String {
        return name
    }

    fun setName(playerName : String){
        this.name = playerName
    }

    fun getScore() : Int {
        return score
    }

    fun changeScore(amount : Int) {
        score += amount
    }

    fun setShooting(isShooting: Boolean) {
        playerShip.setShooting(isShooting)
    }
}
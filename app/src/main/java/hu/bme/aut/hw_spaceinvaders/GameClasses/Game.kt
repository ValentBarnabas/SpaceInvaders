package hu.bme.aut.hw_spaceinvaders.GameClasses

import hu.bme.aut.hw_spaceinvaders.Data.FirebaseScoreHandler
import hu.bme.aut.hw_spaceinvaders.GameLogic.GameController
import kotlin.random.Random

object Game {

    private lateinit var gameController : GameController
    private var running: Boolean = false
    private var paused: Boolean = false

    private var height : Int = 0
    private var width : Int = 0
    private const val speedBoost : Int = 16

    private var spaceObjs = mutableListOf<SpaceObject>()
    private var player : Player = Player("Anonymous")

    private var nextEnemyAt : Int = 0

    fun tick() {
        if(player.getAlive()) {
            player.playerShip.Step()
            player.playerShip.CheckBounds(width, height, gameController.getSpriteWidth(), this)
            player.playerShip.CheckCollision(spaceObjs, gameController.getSpriteWidth(), gameController.getSpriteHeight())

            for (i in spaceObjs.size-1 downTo 0) {
                if (i < spaceObjs.size) {   //needed check because of concurrent modification, simplest solution
                    var so = spaceObjs[i]
                    so.Step()
                    so.CheckBounds(width, height, gameController.getSpriteWidth(), this)
                    so.CheckCollision(spaceObjs, gameController.getSpriteWidth(), gameController.getSpriteHeight())
                }
            }

            enemyControl()
        }
    }

    private fun enemyControl() {
        if(nextEnemyAt <= 0) {
            var newEnemy = (Enemy(Random.nextInt(0, width - gameController.getSpriteScaling()).toFloat()))
            addSpaceObj(newEnemy)
            nextEnemyAt = Random.nextInt(Math.max(35, (100-player.getScore()/5)))
        }
        nextEnemyAt--
        if(nextEnemyAt < 0) nextEnemyAt = Math.abs(nextEnemyAt)
    }

    private fun addSpaceObj(so : SpaceObject) {
        spaceObjs.add(so)
    }

    fun removeSpaceObj(so: SpaceObject) {
        spaceObjs.remove(so)
    }

    fun changeScore(amount : Int) {
        player.changeScore(amount)
    }

    fun setSize(width: Int, height: Int){
        this.height = height
        this.width = width
    }

    fun setup(playerName : String) {
        player = Player(playerName)
        running = true
        paused = false
        spaceObjs = mutableListOf<SpaceObject>()
    }

    fun setPlayerStartingPosition() {
        player.setShipX(width/2 - gameController.getSpriteScaling()/2)          //width/2 for centering, spriteScale/2 because of sprite scaling and sprite equating to middle
        player.setShipY(height- gameController.getSpriteScaling()-8)            //-spriteScale because of scaling of sprite, -8 to have a little elevation
    }

    fun playerShooting() {
        player.setShooting(true)
    }

    fun addShot(x: Float, y: Float) {
        var tempBullet = Bullet()
        tempBullet.setX(x)
        tempBullet.setY(y)
        tempBullet.setVel(10)
        addSpaceObj(tempBullet)
    }

    fun setGameController(gc : GameController) { gameController = gc }
    fun setPlayerVel(vel : Float) { player.setShipVel(vel * width / speedBoost) }

    fun getSpaceObjectList() : MutableList<SpaceObject> { return spaceObjs }
    fun getPlayer() : Player { return player }
    fun getRunning() : Boolean { return running }
    fun getPaused() : Boolean { return paused }

    fun stopGame() { running = false }
    fun pauseGame() { paused = true }
    fun unpauseGame(){ paused = false }

    private fun gameOver() {
        pauseGame()
        var fbHandler = FirebaseScoreHandler()
        fbHandler.newScore(player.getName(), player.getScore())
        stopGame()
    }

    fun playerDied() {
        player.setAlive(false)
        gameOver()
    }

    fun enemyDied(e: Enemy, b: Bullet) {
        removeSpaceObj(e)
        removeSpaceObj(b)
        player.changeScore(10)
    }

    fun bulletHit(b: Bullet, e: Enemy) {
        removeSpaceObj(b)
        removeSpaceObj(e)
    }

    fun setRunning(running : Boolean) {
        this.running = running
        if(running) {
            gameController.start()
        }
    }
}
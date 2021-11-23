package hu.bme.aut.hw_spaceinvaders.GameClasses

import android.util.Log
import hu.bme.aut.hw_spaceinvaders.GameLogic.GameController
import kotlin.random.Random

object Game {

    private lateinit var gameController : GameController
    private var running: Boolean = false
    private var paused: Boolean = false

    private var height : Int = 0
    private var width : Int = 0

    private var spaceObjs = mutableListOf<SpaceObject>()
    private var player : Player = Player()

    private var nextEnemyAt : Int = 0

    fun tick() {
        if(player.isAlive()) {
            player.playerShip.Step()
            player.playerShip.CheckBounds(width, height, this)
            for (i in spaceObjs.size-1 downTo 0) {
                var so = spaceObjs[i]
                so.Step()
                so.CheckBounds(width, height, this)
            }

            enemyControl()
        }

    }

    private fun enemyControl() {
        if(nextEnemyAt <= 0) {
            var newEnemy = (Enemy(Random.nextInt(0, width- gameController.getRendering().spriteScale).toFloat()))
            addSpaceObj(newEnemy)
            nextEnemyAt = Random.nextInt(Math.max(35, (100-player.getScore()/5)))
        }
        nextEnemyAt--
        if(nextEnemyAt < 0) nextEnemyAt = Math.abs(nextEnemyAt)
    }

    private fun addSpaceObj(so : SpaceObject) {
        spaceObjs.add(so)
    }

    public fun removeSpaceObj(so: SpaceObject) {
        spaceObjs.remove(so)
    }

    fun changeScore(amount : Int) {
        player.setScore(amount)
    }

    fun setSize(width: Int, height: Int){
        this.height = height
        this.width = width

        setup()
    }

    fun setup() {
        player = Player()
        //TODO: remove magic numbers
        player.playerShip.setX((width/2-86/2).toFloat())    //width/2 for centering, 86/2 because of sprite scaling and sprite equating to middle
        player.playerShip.setY((height-86-8).toFloat())     //-86 because of scaling of sprite, -8 to have a little elevation
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

    fun getSpaceObjectList() : MutableList<SpaceObject> {
        return spaceObjs
    }
    fun getPlayer() : Player {
        return player
    }

    fun setPlayerVel(vel : Float) {
        player.playerShip.setVel(vel)
    }
    fun getRunning() : Boolean {
        return running
    }
    fun getPaused() : Boolean {
        return paused
    }

    fun stopGame() {
         running = false
    }
    fun pauseGame() {
        paused = true
    }
    fun unpauseGame(){
        paused = false
    }
    fun setGameController(gc : GameController) {
        gameController = gc
    }
    fun setRunning(running : Boolean) {
        this.running = running
        if(running == true) {
            gameController.start()
        }
    }
}
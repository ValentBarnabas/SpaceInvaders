package hu.bme.aut.hw_spaceinvaders.GameClasses

import hu.bme.aut.hw_spaceinvaders.GameLogic.GameController
import java.util.*

object Game {

    private var height : Int = 0
    private var width : Int = 0

    private val random = Random()
    private var entities = mutableListOf<SpaceObject>()
    private var player : Player = Player()

    private lateinit var gameController : GameController
    private var running: Boolean = false

    private var nextEnemyAt : Int = 0

    fun tick() {
        if(player.isAlive()) {
            player.Step()
            for (entity in entities) {
                entity.Step()
                //TODO: check if entity is out of bound, if so, put them back or destroy them
            }

            enemyControl()
        }

    }

    fun enemyControl() {
        if(nextEnemyAt == 0) {
            //		Random random = new Random();
            //		if(nextEnemyAt == 0) {
            //			addEntity(new Enemy(game.getGameWidth(), Math.max(random.nextInt(game.getGameHeight()), 32), game.getTextures(), this));
            //			nextEnemyAt = random.nextInt(Math.max( 35, (100-game.getScore()/5) ));
            //		}
            //		nextEnemyAt--;
            //		if(nextEnemyAt < 0) nextEnemyAt = Math.abs(nextEnemyAt); //Sometimes it goes to -, this fixes problem
        }
    }

    fun setSize(width: Int, height: Int){
        this.height = height
        this.width = width
    }

    fun getEntityList() : MutableList<SpaceObject> {
        return entities
    }
    fun getPlayer() : Player {
        return player
    }
    fun setPlayerVel(vel : Float) {
        player.setVel(vel)
    }
    fun getRunning() : Boolean {
        return running
    }
    fun stopGame() {
         running = false
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
package hu.bme.aut.hw_spaceinvaders.GameLogic

import hu.bme.aut.hw_spaceinvaders.GameClasses.Game
import hu.bme.aut.hw_spaceinvaders.Visuals.Rendering

class GameController (rendering: Rendering): Thread() {

    private var rendering = rendering

    companion object {  //object for limiting fps
        private const val FPS: Long = 60
        private const val TIME_BETWEEN_FRAMES = 1000 / FPS
    }

    override fun run() {
        Game.setSize(rendering.getWidth(), rendering.getHeight())
        Game.setPlayerStartingPosition()
        while(Game.getRunning()) {
            if(!Game.getPaused()) {
                val start = System.currentTimeMillis()
                Game.tick()
                rendering.draw()
                val end = System.currentTimeMillis()

                val sleepTime = TIME_BETWEEN_FRAMES - (end-start)
                if(sleepTime > 0) {
                    sleep(sleepTime)
                } else {
                    sleep(5)
                }
            }
        }
        join()
    }

    fun getRendering() : Rendering {
        return rendering
    }
}
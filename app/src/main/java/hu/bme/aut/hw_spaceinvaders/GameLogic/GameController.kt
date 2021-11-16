package hu.bme.aut.hw_spaceinvaders.GameLogic

import android.util.Log
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game
import hu.bme.aut.hw_spaceinvaders.Visuals.Rendering

class GameController (rendering: Rendering): Thread() {

    private var rendering = rendering

    override fun run() {
        while(Game.getRunning()) {
            Game.tick()
            rendering.draw()
        }
        join()
    }

    fun setPlayerVel(vel : Float) {
        Game.setPlayerVel(vel)
    }
}
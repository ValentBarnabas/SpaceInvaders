package hu.bme.aut.hw_spaceinvaders.GameLogic

import android.content.Context
import android.util.Log
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game
import hu.bme.aut.hw_spaceinvaders.Visuals.Rendering

class GameController (rendering: Rendering): Thread() {

    private var rendering = rendering

    override fun run() {
        Game.setSize(rendering.getWidth(), rendering.getHeight())
        while(Game.getRunning()) {
            if(!Game.getPaused()) {
                Game.tick()
                rendering.draw()
            }
        }
        join()
    }

    fun getRendering() : Rendering {
        return rendering
    }

    fun setPlayerVel(vel : Float) {
        Game.setPlayerVel(vel)
    }
}
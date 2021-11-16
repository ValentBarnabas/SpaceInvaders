package hu.bme.aut.hw_spaceinvaders.Visuals

import android.content.Context
import android.graphics.Canvas
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game

class Rendering (
    private val context: Context,
    private val view: GameView,
    private val height: Int,
    private val width: Int
 ) {

    private val background = Background(context)

    init{
        background.setSize(width, height)
    }

    fun draw() {
        var canvas : Canvas? = null
        try {
            canvas = view.holder.lockCanvas()
            synchronized(view.holder) {
                background.draw(canvas)
                for (entity in Game.getEntityList()) {
                    //TODO: draw entities
                }
                //TODO: draw player
            }
        } finally {
            if (canvas != null) {
                view.holder.unlockCanvasAndPost(canvas)
            }
        }
    }

}
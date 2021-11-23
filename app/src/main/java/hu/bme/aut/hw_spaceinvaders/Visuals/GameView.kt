package hu.bme.aut.hw_spaceinvaders.Visuals

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game
import hu.bme.aut.hw_spaceinvaders.GameLogic.GameController

class GameView : SurfaceView {

    //TODO: check if i can remove any of these
    constructor (context: Context) : super (context)
    constructor (context: Context, attribSet: AttributeSet) : super(context, attribSet)
    constructor (context: Context, attribSet: AttributeSet, defStyleAttr: Int) : super(context, attribSet, defStyleAttr)

    init {
        holder.addCallback(object : SurfaceHolder.Callback{
            override fun surfaceCreated(holder: SurfaceHolder) {

            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {
                var rendering = Rendering(context, this@GameView, height, width)
                var gameController = GameController(rendering)
                Game.setGameController(gameController)
                Game.setRunning(true)
                Game.unpauseGame()
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                while (Game.getRunning()) {
                    Game.stopGame()
                }
            }
        })
    }
}
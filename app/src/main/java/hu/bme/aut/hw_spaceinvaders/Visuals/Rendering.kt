package hu.bme.aut.hw_spaceinvaders.Visuals

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game
import hu.bme.aut.hw_spaceinvaders.GameClasses.Player
import hu.bme.aut.hw_spaceinvaders.GameClasses.SpaceObject
import hu.bme.aut.hw_spaceinvaders.R

class Rendering (
    private val context: Context,
    private val view: GameView,
    private val height: Int,
    private val width: Int
 ) {

    private val density : Float = Resources.getSystem().displayMetrics.density

    val spriteWidth = 64
    val spriteHeight = 64
    val spriteScale = 86

    private val textPaint : Paint = Paint()

    private val background = Background()
    private val sprite : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.space_invaders_sptire_sheet)

    init{
        background.setSize(width, height)
        textPaint.textSize = 128.0f / density
    }

    fun draw() {
        var canvas : Canvas? = null
        try {
            canvas = view.holder.lockCanvas()
            synchronized(view.holder) {
                background.Draw(canvas)
                for (so in Game.getSpaceObjectList()) {
                    drawSpaceObject(canvas, so)
                }
                drawPlayer(canvas, Game.getPlayer())
            }

            if(Game.getRunning()) canvas.drawText("Score: " + Game.getPlayer().getScore(), 32.0f / density, textPaint.textSize + (32.0f / density), textPaint)

            if(!Game.getRunning()) {
                textPaint.textSize = 200.0f / density
                canvas.drawText("Game Over", 64.0f/density, height/2.toFloat(), textPaint)
                textPaint.textSize = 128.0f / density
                canvas.drawText("Score: " + Game.getPlayer().getScore(), 64.0f/density, height/2.toFloat()+128.0f/density, textPaint)
            }
        } finally {
            if (canvas != null) {
                view.holder.unlockCanvasAndPost(canvas)
            }
        }
    }

    private fun drawPlayer(canvas: Canvas, player: Player) {
        val od = player.playerShip.getInfo()
        val src = Rect(0,0,spriteWidth-1,spriteHeight-1)
        val dst = Rect(od.x, od.y, od.x + spriteScale, od.y + spriteScale)
        canvas.drawBitmap(sprite, src, dst, null)
    }
    private fun drawSpaceObject(canvas: Canvas, so : SpaceObject) {
        val od = so.getInfo()
        var src = Rect(1+od.imgIdx%4*spriteWidth,0,spriteWidth+od.imgIdx%4*spriteWidth-1, spriteHeight-1)
        if(od.imgIdx > 3) {
            src.top += spriteHeight
            src.bottom += spriteHeight
        }
        val dst = Rect(od.x, od.y, od.x + spriteScale, od.y + spriteScale)
        canvas.drawBitmap(sprite, src, dst, null)
    }

    fun getWidth() : Int{
        return width
    }

    fun getHeight() : Int {
        return height
    }
}
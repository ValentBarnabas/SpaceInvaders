package hu.bme.aut.hw_spaceinvaders.Visuals

import android.content.Context
import android.graphics.*
import com.google.android.material.resources.MaterialResources.getDimensionPixelSize
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

    val spriteWidth = 64
    val spriteHeight = 64
    val spriteScale = 86

    private val textPaint : Paint = Paint()

    private val background = Background(context)
    private val sprite : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.space_invaders_sptire_sheet)

    init{
        background.setSize(width, height)
        //TODO: make it sp somehow
        textPaint.textSize = 64.0f
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
            canvas.drawText("Score: " + Game.getPlayer().getScore(), 10F, textPaint.textSize+10, textPaint)
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
        var src = Rect(0+od.imgIdx%4*spriteWidth,0,spriteWidth-1+od.imgIdx%4*spriteWidth,spriteHeight-1)
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
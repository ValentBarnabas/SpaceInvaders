package hu.bme.aut.hw_spaceinvaders.Visuals

import android.content.Context
import android.graphics.*
import android.util.Log
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

    private val background = Background(context)
    private val sprite : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.space_invaders_sptire_sheet)

    init{
        background.setSize(width, height)
    }

    fun draw() {
        var canvas : Canvas? = null
        try {
            canvas = view.holder.lockCanvas()
            synchronized(view.holder) {
                background.Draw(canvas)
                for (so in Game.getSpaceObjectList()) {
                    //TODO: draw spaceObjects
                    drawSpaceObject(canvas, so)
                }
                //TODO: draw player
                drawPlayer(canvas, Game.getPlayer())
            }
        } finally {
            if (canvas != null) {
                view.holder.unlockCanvasAndPost(canvas)
            }
        }
    }

    private fun drawPlayer(canvas: Canvas, player: Player) {
        val src = Rect(0,0,spriteWidth-1,spriteHeight-1)
        val dst = Rect(player.playerShip.getX().toInt(), player.playerShip.getY().toInt(),
            player.playerShip.getX().toInt()+spriteScale, player.playerShip.getY().toInt()+spriteScale)
        canvas.drawBitmap(sprite, src, dst, null)
    }
    private fun drawSpaceObject(canvas: Canvas, so : SpaceObject) {
        var src = Rect(0+so.imgIdx%4*spriteWidth,0,spriteWidth-1+so.imgIdx%4*spriteWidth,spriteHeight-1)
        if(so.imgIdx > 3) {
            src.top += spriteHeight
            src.bottom += spriteHeight
        }
        val dst = Rect(so.getX().toInt(), so.getY().toInt(), so.getX().toInt()+spriteScale, so.getY().toInt()+spriteScale)
        canvas.drawBitmap(sprite, src, dst, null)
    }

    fun getWidth() : Int{
        return width
    }

    fun getHeight() : Int {
        return height
    }
}
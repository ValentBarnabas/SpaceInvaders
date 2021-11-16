package hu.bme.aut.hw_spaceinvaders.Visuals

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import hu.bme.aut.hw_spaceinvaders.GameClasses.ISteppable
import kotlin.random.Random

class Star constructor(var posX: Int, var posY: Int = 0) : IDrawable, ISteppable {
    private var size : Int = Random.nextInt(8,16)
    private var vel : Int = Random.nextInt(1,4)

    override fun Draw(canvas: Canvas) {
        val starRect = Rect(posX, posY, posX+size, posY+size)
        val starColor = Paint()
        starColor.setARGB(255,0,0,0)
        canvas.drawRect(starRect, starColor)
    }

    override fun Step() {
        posY += vel
    }
}
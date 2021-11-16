package hu.bme.aut.hw_spaceinvaders.Visuals

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import kotlin.random.Random

class Background (private val context: Context) : IDrawable {

    private var width : Int = 0
    private var height : Int = 0

    private var starList = mutableListOf<Star>()

    fun setSize(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    override fun Draw(canvas : Canvas) {

        randomlyAddStar(16)

        val bgRect = Rect(0,0, width, height)
        var bgColor = Paint()
        bgColor.setARGB(255,0,255,0)
        canvas.drawRect(bgRect, bgColor)

        for(i in starList.size-1 downTo 0) {
            var star = starList[i]
            star.Draw(canvas)
            star.Step()
            if(star.posY > height) starList.removeAt(i)
        }
    }

    fun randomlyAddStar(randLimit : Int) {
        if(Random.nextInt(0, randLimit) % randLimit == 0) {
            var tmp = Star(Random.nextInt(0, width))
            starList.add(tmp)
        }
    }
}
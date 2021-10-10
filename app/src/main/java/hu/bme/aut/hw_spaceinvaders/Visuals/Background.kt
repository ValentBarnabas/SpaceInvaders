package hu.bme.aut.hw_spaceinvaders.Visuals

import android.content.Context

class Background (context: Context) {

    private var width : Int = 0
    private var height : Int = 0

    companion object Star {
        private var posX : Int = 0
        private var posY : Int = 0
        private var size : Int = 0

        fun draw() {

        }
    }

    private var starList = mutableListOf<Star>()

    fun setSize(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    fun draw() {
        //TODO: draw background and stars on it
        //TODO: draw rectangle
        for (star in starList) {
            star.draw()
        }
    }
}
package hu.bme.aut.hw_spaceinvaders.Visuals

import android.graphics.Canvas

interface IDrawable {
    //TODO: make Draw get the canvas as input parameter, so model will only have to give x y coords and image idx for it to work
    fun Draw(canvas: Canvas);
}
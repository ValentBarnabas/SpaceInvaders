package hu.bme.aut.hw_spaceinvaders.GameLogic

import android.graphics.Rect
import android.util.Log
import hu.bme.aut.hw_spaceinvaders.GameClasses.SpaceObject

fun Collision(so: SpaceObject, soList: List<SpaceObject>, width: Int, height: Int) {
    for (i in soList.size-1 downTo 0) {
        //TODO: remove if changed to iterators
        if (i < soList.size) {
            var soTemp = soList[i]
            if(so != soTemp && getBounds(so, width, height).intersect(getBounds(soTemp, width, height))) {
                Log.i("collision", "collision happened between " + so.javaClass + " and " + soTemp.javaClass + " at: " + so.getX() + ":" + so.getY())
                so.CollideWith(soTemp)
            }
        }
    }
}

private fun getBounds(so: SpaceObject, width: Int, height: Int): Rect {
    return Rect(so.getX().toInt(), so.getY().toInt(), so.getX().toInt()+width, so.getY().toInt()+height)
}
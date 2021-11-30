package hu.bme.aut.hw_spaceinvaders.GameLogic

import android.graphics.Rect
import hu.bme.aut.hw_spaceinvaders.GameClasses.SpaceObject

fun Collision(so: SpaceObject, soList: List<SpaceObject>, width: Int, height: Int) {
    for (i in soList.size-1 downTo 0) {
        if (i < soList.size) {  //needed check because of concurrent modification, simplest solution
            var soTemp = soList[i]
            if(so != soTemp && getBounds(so, width, height).intersect(getBounds(soTemp, width, height))) {
                so.CollideWith(soTemp)
            }
        }
    }
}

private fun getBounds(so: SpaceObject, width: Int, height: Int): Rect {
    return Rect(so.getX().toInt(), so.getY().toInt(), so.getX().toInt()+width, so.getY().toInt()+height)
}
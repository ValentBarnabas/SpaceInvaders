package hu.bme.aut.hw_spaceinvaders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game

//TODO: implement back button not quitting app, but instead pausing game, and opening popup window. Also, instead of quitting the app, go back to StartActivity

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    override fun onBackPressed() {
        if(Game.getRunning()) {
            Game.pauseGame();
        } else {
            super.onBackPressed()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(Game.getRunning() && Game.getPaused()) {
            Game.unpauseGame()
        }
        return super.onTouchEvent(event)
    }
}
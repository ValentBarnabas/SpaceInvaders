package hu.bme.aut.hw_spaceinvaders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game
import hu.bme.aut.hw_spaceinvaders.Senzor.GyroscopeHelper

//TODO: implement back button not quitting app, but instead pausing game, and opening popup window. Also, instead of quitting the app, go back to StartActivity

class GameActivity : AppCompatActivity() {

    private lateinit var gyroscopeHelper: GyroscopeHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Game.setPlayerName(intent.getStringExtra("playerName").toString())
        setContentView(R.layout.activity_game)
        gyroscopeHelper = GyroscopeHelper(this)
    }

    override fun onResume() {
        super.onResume()
        gyroscopeHelper.start()
    }

    override fun onPause() {
        gyroscopeHelper.stop()
        super.onPause()
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
        } else if (Game.getRunning() && !Game.getPaused() && event?.action == MotionEvent.ACTION_DOWN) {
            Game.playerShooting()
        }
        return super.onTouchEvent(event)
    }
}
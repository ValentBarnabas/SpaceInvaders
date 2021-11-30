package hu.bme.aut.hw_spaceinvaders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import hu.bme.aut.hw_spaceinvaders.GameClasses.Game
import hu.bme.aut.hw_spaceinvaders.Senzor.GyroscopeHelper

class GameActivity : AppCompatActivity() {

    private lateinit var gyroscopeHelper: GyroscopeHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Game.setup(intent.getStringExtra("playerName").toString())
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
        if(Game.getRunning() && !Game.getPaused()) {
            Game.pauseGame()
        } else if (Game.getRunning() && Game.getPaused()) {
            var dialogBuilder = AlertDialog.Builder(this)
            val popupView = layoutInflater.inflate(R.layout.popup_quit_during_gameplay, null)

            dialogBuilder.setView(popupView)
            var dialog = dialogBuilder.create()
            dialog.show()

            var okBtn = popupView.findViewById<Button>(R.id.popupQuitDuringGameOKBtn)
            okBtn.setOnClickListener {
                Game.pauseGame()
                Game.stopGame()
                dialog.dismiss()
                finish()
            }
        } else if (!Game.getRunning()) {
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
package hu.bme.aut.hw_spaceinvaders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//TODO: implement back button not quitting app, but instead pausing game, and opening popup window. Also, instead of quittin the app, go back to StartActivity

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
}
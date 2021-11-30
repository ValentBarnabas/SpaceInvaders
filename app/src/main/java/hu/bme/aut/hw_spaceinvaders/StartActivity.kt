package hu.bme.aut.hw_spaceinvaders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import hu.bme.aut.hw_spaceinvaders.databinding.ActivityStartBinding
import kotlin.system.exitProcess

class StartActivity : AppCompatActivity() {

    private lateinit var binding : ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.StartButton.setOnClickListener{

            var dialogBuilder = AlertDialog.Builder(this)
            val popupView = layoutInflater.inflate(R.layout.popup_player_name, null)

            dialogBuilder.setView(popupView)
            var dialog = dialogBuilder.create()
            dialog.show()

            var okBtn = popupView.findViewById<Button>(R.id.okButton)
            var playerName = ""
            okBtn.setOnClickListener {
                playerName = popupView.findViewById<EditText>(R.id.playerNameET).text.toString()
                var intent = Intent(this@StartActivity, GameActivity::class.java)
                intent.putExtra("playerName", playerName)
                startActivity(intent)
                dialog.hide()
            }

        }

        binding.ScoreButton.setOnClickListener{
            startActivity(Intent(this@StartActivity, ScoreBoardActivity::class.java))
        }

        binding.ExitButton.setOnClickListener{
            exitProcess(-1)
        }
    }
}
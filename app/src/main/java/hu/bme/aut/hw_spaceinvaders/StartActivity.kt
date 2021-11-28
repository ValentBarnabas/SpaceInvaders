package hu.bme.aut.hw_spaceinvaders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseApp
import hu.bme.aut.hw_spaceinvaders.Data.FirebaseScoreHandler
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
            var intent = Intent(this@StartActivity, GameActivity::class.java)

            startActivity(intent)
            finish()
        }
        binding.ScoreButton.setOnClickListener{
            startActivity(Intent(this@StartActivity, ScoreBoardActivity::class.java))
        }

        binding.ExitButton.setOnClickListener{
            exitProcess(-1)
        }
    }
}
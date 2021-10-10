package hu.bme.aut.hw_spaceinvaders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hu.bme.aut.hw_spaceinvaders.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener{
            startActivity(Intent(this@StartActivity, GameActivity::class.java))
            finish()
        }
    }


}
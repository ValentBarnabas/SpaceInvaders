package hu.bme.aut.hw_spaceinvaders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.hw_spaceinvaders.Data.FirebaseScoreHandler
import hu.bme.aut.hw_spaceinvaders.Data.Scores
import hu.bme.aut.hw_spaceinvaders.databinding.ActivityScoreBoardBinding

class ScoreBoardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityScoreBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBoardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadScores()
    }

    private fun loadScores() {
        FirebaseScoreHandler().getScores(this)
    }

    fun receiveScores(scores : MutableList<Scores>) {
        scores.sortByDescending { o -> o.score }
        binding.tvPlace1.text = (scores[0].playerName + " " + scores[0].score)
        binding.tvPlace2.text = (scores[1].playerName + " " + scores[1].score)
        binding.tvPlace3.text = (scores[2].playerName + " " + scores[2].score)
        binding.tvPlace4.text = (scores[3].playerName + " " + scores[3].score)
        binding.tvPlace5.text = (scores[4].playerName + " " + scores[4].score)
    }
}
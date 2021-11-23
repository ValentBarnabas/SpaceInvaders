package hu.bme.aut.hw_spaceinvaders.Data

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseScoreHandler {

    //Use with following code:
    //FirebaseScoreHandler().newScore("fromCode", 130)

    fun newScore(playerName: String, playerScore: Int) {
        val newScore = Scores("0", playerName, playerScore)

        val db = Firebase.firestore

        var scoreList: MutableList<Scores> = mutableListOf<Scores>()

        db.collection("scores")
            .get()
            .addOnSuccessListener { result ->
                for (temp in result) {
//                    Log.i("teszt", temp.data.get("playerName").toString() + " " + temp.data.get("score").toString())
                    scoreList.add(Scores(temp.id, temp.data.get("playerName").toString(), temp.data.get("score").toString().toInt()))
                }
                scoreList.add(newScore)

                scoreList.sortBy { o -> o.score }

                if (newScore.score != scoreList.get(0).score) {
                    db.collection("scores").document(scoreList.get(0).id).delete()
                    scoreList.removeAt(0)
                    db.collection("scores").add(FirebaseScores(newScore.playerName, newScore.score))
                }
            }
    }

}
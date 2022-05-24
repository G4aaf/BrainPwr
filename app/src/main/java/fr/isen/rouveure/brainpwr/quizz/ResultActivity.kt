package fr.isen.rouveure.brainpwr.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.rouveure.brainpwr.HomeActivity
import fr.isen.rouveure.brainpwr.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        tv_score.text = "Nombre de question répondu $totalQuestions"
        btn_finish.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}
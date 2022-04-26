package fr.isen.rouveure.brainpwr.game


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import fr.isen.rouveure.brainpwr.R

class PlayActivity : AppCompatActivity(), GameTask {

    private lateinit var playBtn: ImageView
    private lateinit var rootLayout : LinearLayout
    private lateinit var  mGameView: GameView
    lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        playBtn = findViewById(R.id.playBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        mGameView = GameView(this, this)

        val action = supportActionBar
        action?.hide()
        playBtn.setOnClickListener{
            mGameView.setBackgroundResource(R.drawable.background_game)
            rootLayout.addView(mGameView)
            playBtn.visibility = View.GONE
        }

        rootLayout = findViewById(R.id.rootLayout)
        mGameView = GameView(this, this)
    }

    override fun closeGame(mScore: Int) {
        score.text = "Score : $mScore"
        rootLayout.removeView(mGameView)
        playBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE
    }
}

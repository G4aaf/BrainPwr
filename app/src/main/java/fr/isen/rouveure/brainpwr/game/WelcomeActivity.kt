package fr.isen.rouveure.brainpwr.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import fr.isen.rouveure.brainpwr.R
import java.lang.Exception

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val action = supportActionBar
        action?.hide()
        try{
            Handler().postDelayed({
                startActivity(Intent(
                    this,
                    PlayActivity::class.java))
            },2800)
        }
        catch (e:Exception){
            e.printStackTrace()
        }
    }
}
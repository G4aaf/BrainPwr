package fr.isen.rouveure.brainpwr.PatientGold

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import fr.isen.rouveure.brainpwr.HomeActivity
import fr.isen.rouveure.brainpwr.R
import fr.isen.rouveure.brainpwr.game.PlayActivity
import java.lang.Exception

class ReleasePaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_release_payment)

        val action = supportActionBar
        action?.hide()
        try{
            Handler().postDelayed({
                startActivity(
                    Intent(
                    this,
                        HomeActivity::class.java)
                )
            },2800)
        }
        catch (e: Exception){
            e.printStackTrace()
        }
    }
}
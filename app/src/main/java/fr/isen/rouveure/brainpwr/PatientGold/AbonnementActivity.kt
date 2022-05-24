package fr.isen.rouveure.brainpwr.PatientGold

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.rouveure.brainpwr.HomeActivity
import fr.isen.rouveure.brainpwr.R
import fr.isen.rouveure.brainpwr.databinding.ActivityAbonnementBinding


class AbonnementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAbonnementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abonnement)

        binding = ActivityAbonnementBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //The user wants to access HomeActivity
        binding.paimentBtn.setOnClickListener{
            val intent = Intent(this, ReleasePaymentActivity::class.java )
            startActivity(intent)
        }
    }
}
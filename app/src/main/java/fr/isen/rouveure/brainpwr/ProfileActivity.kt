package fr.isen.rouveure.brainpwr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.rouveure.brainpwr.PatientGold.AbonnementActivity
import fr.isen.rouveure.brainpwr.databinding.ActivityProfileBinding


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //The user wants to access playstore
        binding.basket.setOnClickListener{
            val intent = Intent(this, AbonnementActivity::class.java )
            startActivity(intent)
        }


    }

}
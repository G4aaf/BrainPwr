package fr.isen.rouveure.brainpwr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.rouveure.brainpwr.databinding.ActivityHomeBinding
import fr.isen.rouveure.brainpwr.game.WelcomeActivity
import fr.isen.rouveure.brainpwr.quizz.QuizzActivity
import fr.isen.rouveure.brainpwr.sleep.BluetoothActivity
import fr.isen.rouveure.brainpwr.sleep.SleepActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //The user wants to access the Game
        binding.gameId.setOnClickListener{
            val intent = Intent(this, WelcomeActivity::class.java )
            startActivity(intent)
        }
        //if the user wants to access the Quizz
        binding.quizzId.setOnClickListener{
            val intent = Intent( this, QuizzActivity::class.java)
            startActivity(intent)
        }
        //if the user wants to access sleep routine
        binding.sleepId.setOnClickListener{
            val intent = Intent(this, SleepActivity::class.java)
            startActivity(intent)
        }

        //if the user wants to access his schedule
        binding.scheduleCard.setOnClickListener {
            val intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }

        //if the user wants to access his Profile
        binding.profileId.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

}
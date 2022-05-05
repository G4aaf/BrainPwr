package fr.isen.rouveure.brainpwr.sleep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.rouveure.brainpwr.R
import fr.isen.rouveure.brainpwr.databinding.ActivityHomeBinding
import fr.isen.rouveure.brainpwr.databinding.ActivitySleepBinding

class SleepActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySleepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep)

        binding = ActivitySleepBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //if the user wants to access sleep routine
        binding.btnConnectBluetooth.setOnClickListener{
            val intent = Intent(this, BluetoothActivity::class.java)
            startActivity(intent)
        }
    }
}
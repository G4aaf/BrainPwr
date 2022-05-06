package fr.isen.rouveure.brainpwr.sleep

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.isen.rouveure.brainpwr.R
import kotlinx.android.synthetic.main.activity_bluetooth.*

class BluetoothActivity : AppCompatActivity() {

    private var RESQUEST_CODE_ENABLE_BT: Int = 1;
    private var RESQUEST_CODE_DISCOVERABLE_BT: Int = 2;

    //Bluetooth adaptater
    lateinit var bAdaptater:BluetoothAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)

        //init bluetooth adapter
        bAdaptater = BluetoothAdapter.getDefaultAdapter()
        //check if bluetooth is on/off
        if(bAdaptater == null){
            statusBluetoothTv.text = "Bluetooth non connecté"
        }else{
            statusBluetoothTv.text = "Bluetooth activé"
        }
        // turn on bluetooth
        turnOnBtn.setOnClickListener {
            if (bAdaptater.isEnabled){
                //already enabled
                Toast.makeText(this, "Already on", Toast.LENGTH_LONG).show()
            } else {
                //turn on bluetooth
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(intent, RESQUEST_CODE_ENABLE_BT)
            }
        }

        //discoverable the bluetooth
        discoverableBtn.setOnClickListener {
            if (!bAdaptater.isDiscovering){
                Toast.makeText(this, "Making Your device discoverable", Toast.LENGTH_LONG).show()
                val intent = Intent(Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE))
                startActivityForResult(intent, RESQUEST_CODE_DISCOVERABLE_BT)
            }
        }
        //get list of paired devices
        pairedBtn.setOnClickListener {
            if (bAdaptater.isEnabled){
                pairedTv.text = "Paired Devices"
                //get list of paired devices
                val devices = bAdaptater.bondedDevices
                for (device in devices){
                    val  deviceName = device.name
                    val deviceAdress = device
                    pairedTv.append("\nDevice: $deviceName, $device")
                }
            }else {
                Toast.makeText(this, "Activer le Bluetooth avant", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            RESQUEST_CODE_ENABLE_BT ->
                if (requestCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "Bluetooth est activé", Toast.LENGTH_LONG).show()
                } else {
                    //user denied to turn on bluetooth from confirmation dialog
                    Toast.makeText(this, "Impossible d'activer le Bluetooth", Toast.LENGTH_LONG)
                        .show()
                }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
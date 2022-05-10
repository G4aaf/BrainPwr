package fr.isen.rouveure.brainpwr.sleep

import android.bluetooth.BluetoothGattCharacteristic
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class BleService(title: String, characteristics: MutableList<BluetoothGattCharacteristic>) :
    ExpandableGroup<BluetoothGattCharacteristic>(title, characteristics){

}
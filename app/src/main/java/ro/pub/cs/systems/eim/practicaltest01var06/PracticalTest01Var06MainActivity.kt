package ro.pub.cs.systems.eim.practicaltest01var06

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class PracticalTest01Var06MainActivity : AppCompatActivity() {
    private lateinit var text_1 : TextView
    private lateinit var text_2 : TextView
    private lateinit var text_3 : TextView

    private lateinit var hold_1 : CheckBox
    private lateinit var hold_2 : CheckBox
    private lateinit var hold_3 : CheckBox

    private lateinit var button_1 : Button
    private lateinit var button_2 : Button

    private var checked1 = false;
    private var checked2 = false;
    private var checked3 = false;

    private var checked_count = 0

    private var value1 = 1
    private var value2 = 2
    private var value3 = 3

    private val score = 0;

    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        text_1 = findViewById(R.id.text_1)
        text_2 = findViewById(R.id.text_2)
        text_3 = findViewById(R.id.text_3)

        button_2 = findViewById(R.id.button_2)

        hold_1 = findViewById(R.id.check_1)
        hold_2 = findViewById(R.id.check_2)
        hold_3 = findViewById(R.id.check_3)

        hold_1.setOnCheckedChangeListener { buttonView, isChecked ->
            checked1 = isChecked

            if(isChecked) {
                checked_count ++;
            } else {
                checked_count--;
            }
        }
        hold_2.setOnCheckedChangeListener { buttonView, isChecked ->
                checked2 = isChecked
            if(isChecked) {
                checked_count ++;
            } else {
                checked_count--;
            }
        }

        hold_3.setOnCheckedChangeListener { buttonView, isChecked ->
            checked3 = isChecked
            if(isChecked) {
                checked_count ++;
            } else {
                checked_count--;
            }
        }

        button_2.setOnClickListener {
            if(!checked1){
                value1 = (1..3).random()
                text_1.setText(value1.toString())
            }
            if(!checked2){
                value2 = (1..3).random()
                text_2.setText(value2.toString())
            }

            if(!checked3){
                value3 = (1..3).random()
                text_3.setText(value3.toString())
            }
        }

        button_1 = findViewById(R.id.button_1)

        button_1.setOnClickListener {


            val intent = Intent(this, PracticalTest01Var06SecondaryActivity::class.java).apply {
                putExtra("value1", value1)
                putExtra("value2", value2)
                putExtra("value3", value3)
                putExtra("checked_count", checked_count)
            }
            // Lansează activitatea copil folosind launcher-ul
            startForResult.launch(intent)
        }

        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val someData = data?.getStringExtra("gained")
                val toast = Toast.makeText(this, someData.toString(),Toast.LENGTH_SHORT) // in Activity
                toast.show()
            }

            if(result.resultCode == Activity.RESULT_CANCELED) {
                val toast = Toast.makeText(this, "CANCELED", Toast.LENGTH_SHORT) // in Activity
                toast.show()
            }
        }
    }

    private val someEventBroadcastReceiver = SomeEventBroadcastReceiver()
    private val intentFilter = IntentFilter("ro.pub.cs.systems.eim.practicaltest01var06.MESSAGE")

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(someEventBroadcastReceiver, intentFilter, Context.RECEIVER_EXPORTED)
        } else {
            registerReceiver(someEventBroadcastReceiver, intentFilter)
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(someEventBroadcastReceiver)
    }
}
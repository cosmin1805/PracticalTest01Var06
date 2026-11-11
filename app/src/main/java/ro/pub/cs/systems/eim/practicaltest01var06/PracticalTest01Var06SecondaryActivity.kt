package ro.pub.cs.systems.eim.practicaltest01var06

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06SecondaryActivity : AppCompatActivity() {
    private lateinit var button3: Button
    private lateinit var text4: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_secondary)

        val value1 = intent.getIntExtra("value1",0)
        val value2 = intent.getIntExtra("value2",0)
        val value3 = intent.getIntExtra("value3",0)
        val checked_count = intent.getIntExtra("checked_count",0)

        var gained = 0

        if(value1 == value2 && value2 == value3 && value1 == value2) {
            if(checked_count == 0) {
                gained = 100
            } else if(checked_count == 1) {
                gained = 50
            } else if(checked_count == 2) {
                gained = 10
            } else if(checked_count == 3) {
                gained = 0
            }
        }

        text4 = findViewById(R.id.text_4)
        text4.setText("Gained " + gained.toString())

        button3 = findViewById(R.id.button_3);

        button3.setOnClickListener {
            val intentToParent = Intent()
            intentToParent.putExtra("gained", gained.toString())

            setResult(RESULT_OK, intentToParent)
            finish()
        }

    }
}
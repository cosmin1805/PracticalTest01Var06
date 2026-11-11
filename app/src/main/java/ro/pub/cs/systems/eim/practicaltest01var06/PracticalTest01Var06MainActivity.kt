package ro.pub.cs.systems.eim.practicaltest01var06

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
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

    private var value1 = 1
    private var value2 = 2
    private var value3 = 3

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
        }
        hold_2.setOnCheckedChangeListener { buttonView, isChecked ->
                checked2 = isChecked
        }

        hold_3.setOnCheckedChangeListener { buttonView, isChecked ->
            checked3 = isChecked
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

            if(!checked1){
                val value3 = (1..3).random()
                text_3.setText(value3.toString())
            }
        }

    }
}
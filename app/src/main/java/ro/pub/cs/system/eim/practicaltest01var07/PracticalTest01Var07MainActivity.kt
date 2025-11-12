package ro.pub.cs.system.eim.practicaltest01var07

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.ThreadLocalRandom

class PracticalTest01Var07MainActivity : AppCompatActivity() {

    private lateinit var leftEditText01: EditText
    private lateinit var rightEditText01: EditText
    private lateinit var leftEditText02: EditText
    private lateinit var rightEditText02: EditText
    private lateinit var random: Button
    private lateinit var set: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var07_main)

        // Legăm componentele din XML de variabilele Kotlin
        leftEditText01 = findViewById(R.id.left_edit_text01)
        rightEditText01 = findViewById(R.id.right_edit_text01)
        leftEditText02 = findViewById(R.id.left_edit_text02)
        rightEditText02 = findViewById(R.id.right_edit_text02)
        random = findViewById(R.id.random)
        set = findViewById(R.id.set)

        // Restaurăm manual starea activității (dacă există valori salvate)
        if (savedInstanceState != null) {
            leftEditText01.setText(savedInstanceState.getString("leftCount", "0"))
            rightEditText01.setText(savedInstanceState.getString("rightCount", "0"))
            leftEditText02.setText(savedInstanceState.getString("leftCount", "0"))
            rightEditText02.setText(savedInstanceState.getString("rightCount", "0"))
        }else {
            leftEditText01.setText("")
            rightEditText01.setText("")
            leftEditText02.setText("")
            rightEditText02.setText("")
        }

        // === B.1 ===
        random.setOnClickListener {
            val rnds = (0..10).random()
            val currentValue01 = leftEditText01.text.toString().toIntOrNull() ?: rnds

            val rnds2 = (0..10).random()
            val currentValue02 = rightEditText01.text.toString().toIntOrNull() ?: rnds2

            val rnds3 = (0..10).random()
            val currentValue03 = leftEditText02.text.toString().toIntOrNull() ?: rnds3

            val rnds4 = (0..10).random()
            val currentValue04 = rightEditText02.text.toString().toIntOrNull() ?: rnds4

            leftEditText01.setText((currentValue01).toString())
            rightEditText01.setText((currentValue02).toString())
            leftEditText02.setText((currentValue03).toString())
            rightEditText02.setText((currentValue04).toString())
        }

//        // La apăsarea butonului din dreapta → incrementăm valoarea din dreapta
//        rightButton01.setOnClickListener {
//            val currentValue = rightEditText.text.toString().toIntOrNull() ?: 0
//            rightEditText.setText((currentValue + 1).toString())
//        }

    }
}
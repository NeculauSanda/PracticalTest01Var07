package ro.pub.cs.system.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

        set.setOnClickListener {
            val numb1 = (leftEditText01.text.toString().toIntOrNull() ?: 0)
            val numb2 = (rightEditText01.text.toString().toIntOrNull() ?: 0)
            val numb3 = (leftEditText02.text.toString().toIntOrNull() ?: 0)
            val numb4 = (rightEditText02.text.toString().toIntOrNull() ?: 0)

            val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java)
            intent.putExtra("number1", numb1)
            intent.putExtra("number2", numb2)
            intent.putExtra("number3", numb3)
            intent.putExtra("number4", numb4)
            startActivityForResult(intent, 1)
        }

    }

    fun intentToString(intent: Intent?): String? {
        if (intent == null) {
            return null
        }
        var out = intent.toString()
        val extras = intent.getExtras()
        if (extras != null) {
            extras.size()
            out += "\n"
        }
        if (intent.getAction() != null) out += "\nAction = " + intent.getAction()
        if (intent.getType() != null) out += "\nType = " + intent.getType()
        if (intent.getData() != null) out += "\nData = " + intent.getData()
        if (intent.getPackage() != null) out += "\nPackage = " + intent.getPackage()
        if (intent.getDataString() != null) out += "\nDataString = " + intent.getDataString()
        return out
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
//            val intent = getIntent()
//
//            Log.d("RES", "INTENT = " + intentToString(intent) )
//            val sum = intent.getIntExtra("sum", 0);
            Toast.makeText(this, "Returned with result: $resultCode", Toast.LENGTH_LONG).show()
        } else {
//            val intent = getIntent()
//            val prod = intent.getIntExtra("prod", 0);

            Toast.makeText(this, "Returned with result: $resultCode", Toast.LENGTH_LONG).show()

        }
    }
}
package ro.pub.cs.system.eim.practicaltest01var07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class PracticalTest01Var07SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var07_secondary)

        val left03 = findViewById<TextView>(R.id.left_edit_text03)
        val left04 = findViewById<TextView>(R.id.left_edit_text04)

        val rigth03 = findViewById<TextView>(R.id.right_edit_text04)
        val rigth04 = findViewById<TextView>(R.id.right_edit_text04)
        val sumButton = findViewById<Button>(R.id.sum)
        val prodButton = findViewById<Button>(R.id.prod)

        val num1 = intent.getIntExtra("number1", 0)
        val num2 = intent.getIntExtra("number2", 0)
        val num3 = intent.getIntExtra("number3", 0)
        val num4 = intent.getIntExtra("number4", 0)

        left03.text = num1.toString()
        rigth03.text = num2.toString()
        left04.text = num3.toString()
        rigth04.text = num4.toString()



        sumButton.setOnClickListener {
            val sum = num1 + num2 + num3 + num4
            setResult(sum)
//            val intent = Intent()
//            intent.putExtra("sum", sum)
//            setResult(, intent)
            finish()
        }

        prodButton.setOnClickListener {
            val prod = num1 * num2 * num3 * num4
            setResult(prod)
//            val intent = Intent()
//            intent.putExtra("prod", prod)
//            setResult(RESULT_CANCELED, intent)
            finish()
        }
    }
}
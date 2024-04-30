package com.shin.guess


import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.shin.guess.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    val secretNumber = SecretNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("mainacti", "secret" + secretNumber.secret)
//        setContentView(R.layout.activity_main)
    }

    fun check(view:View){
       val n = binding.number.text.toString().toInt()
        println("number ${n}")
        Log.d("mainacti", "number" + n)
        val message = ""

        if (secretNumber.validate(n)<0){
            Toast.makeText(this, "Bigger", Toast.LENGTH_LONG).show()
             message = "Bigger"
        }
        else if (secretNumber.validate(n)>0){
            Toast.makeText(this, "Smaller", Toast.LENGTH_LONG).show()
            message = "Smaller"
        }
        else
        {
            Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show()
            message = "Correct"
        }
        AlertDialog.Builder(this)
            .setTitle("Message").setMessage(message)
            .setPositiveButton("OK", null)
            .show()
    }
}

package com.devventure.lancamentodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado01 = findViewById<TextView>(R.id.textView01)
        val dado02 = findViewById<TextView>(R.id.textView02)
        val btn = findViewById(R.id.button) as Button

        btn.setOnClickListener {
            dado01.text = gerarAleatorio().toString()
            dado02.text = gerarAleatorio().toString()
        }
    }

    private fun gerarAleatorio(): Int{
        return (1..6).random()
    }

}
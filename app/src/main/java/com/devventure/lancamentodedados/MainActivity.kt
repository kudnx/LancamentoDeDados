package com.devventure.lancamentodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado01 = findViewById<ImageView>(R.id.dado1)
        val dado02 = findViewById<ImageView>(R.id.dado2)
        val btn = findViewById(R.id.button) as Button

        val images = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
                      R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6);

        btn.setOnClickListener {
            dado01.setImageResource(images.random())
            dado02.setImageResource(images.random())
        }
    }
}
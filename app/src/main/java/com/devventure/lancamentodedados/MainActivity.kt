package com.devventure.lancamentodedados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado01 = findViewById<ImageView>(R.id.dado1)
        val dado02 = findViewById<ImageView>(R.id.dado2)
        val btn = findViewById(R.id.button) as Button

        val player = intent.getStringExtra("playerName")
        val welcomeText = findViewById<TextView>(R.id.WelcomeMessage)
        val shareButton = findViewById<FloatingActionButton>(R.id.share)

        welcomeText.text =  getString(R.string.Welcome, player)

        val images = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
                      R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6);

        fun geraNumeroAleatorio() : Int {
            return (0..5).random()
        }

        var soma = 1

        btn.setOnClickListener {
            val num1 = geraNumeroAleatorio()
            val num2 = geraNumeroAleatorio()
            dado01.setImageResource(images[num1])
            dado02.setImageResource(images[num2])
            soma = (num1 + 1) + (num2 + 1)
        }

        shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "O Jogador $player tirou o número: $soma")
            intent.type = "text/plain"

            if(intent.resolveActivity(this.packageManager) != null){
                startActivity(intent)
            } else {
                Toast.makeText(this, "Você não possui o aplicativo instalado!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
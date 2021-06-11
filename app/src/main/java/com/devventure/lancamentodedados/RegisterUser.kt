package com.devventure.lancamentodedados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        val playerName = findViewById<EditText>(R.id.et_playerName)
        val btnEnter   = findViewById<Button>(R.id.btnEnter)

        btnEnter.setOnClickListener{
            if (TextUtils.isEmpty(playerName.text.toString())) {
                Toast.makeText(this, "Digite o nome do jogador!",
                    Toast.LENGTH_SHORT).show()
            }else {
                val player = playerName.text.toString()
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("playerName", player)
                startActivity(intent)
            }
        }
    }
}
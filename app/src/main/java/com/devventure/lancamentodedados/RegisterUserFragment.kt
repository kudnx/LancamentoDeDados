package com.devventure.lancamentodedados

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devventure.lancamentodedados.databinding.FragmentRegisterUserBinding

class RegisterUserFragment : Fragment() {
    private var binding: FragmentRegisterUserBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val playerName = binding?.etPlayerName
        val btnEnter   = binding?.btnEnter

        btnEnter?.setOnClickListener{
            if (TextUtils.isEmpty(playerName?.text.toString())) {
                Toast.makeText(context, "Digite o nome do jogador!",
                    Toast.LENGTH_SHORT).show()
            }else {
                val player = playerName?.text.toString()
                /*val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("playerName", player)
                startActivity(intent)*/
            }
        }

        return binding?.root
    }
}
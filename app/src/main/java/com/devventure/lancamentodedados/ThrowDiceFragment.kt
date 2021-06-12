package com.devventure.lancamentodedados

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.devventure.lancamentodedados.databinding.FragmentThrowDiceBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ThrowDiceFragment : Fragment() {
    var binding : FragmentThrowDiceBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThrowDiceBinding.inflate(inflater, container, false)

        val dado01 = binding?.dado1
        val dado02 = binding?.dado2
        val btn = binding?.button as Button
        val welcomeText = binding?.WelcomeMessage
        val shareButton = binding?.share
        val playerName = arguments?.getString("playerName")

        welcomeText?.text = getString(R.string.Welcome, playerName)

        val images = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
            R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6);

        var soma = 1

        btn.setOnClickListener {
            val num1 = geraNumeroAleatorio()
            val num2 = geraNumeroAleatorio()
            dado01?.setImageResource(images[num1])
            dado02?.setImageResource(images[num2])
            soma = (num1 + 1) + (num2 + 1)
        }

        shareButton?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.result, playerName, soma))
            intent.type = "text/plain"

            activity?.packageManager?.run {
                if (intent.resolveActivity(this) != null){
                    startActivity(intent)
                } else {
                    Toast.makeText(context, getString(R.string.appNotFound),
                        Toast.LENGTH_LONG).show()
                }
            }
        }
        return binding?.root
    }

    fun geraNumeroAleatorio() : Int {
        return (0..5).random()
    }
}
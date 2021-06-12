package com.devventure.lancamentodedados

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.devventure.lancamentodedados.databinding.FragmentRegisterUserBinding

class RegisterUserFragment : Fragment() {
    private var binding: FragmentRegisterUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val playerName = binding?.etPlayerName
        val btnEnter   = binding?.btnEnter

        btnEnter?.setOnClickListener{
            if (TextUtils.isEmpty(playerName?.text.toString())) {
                Toast.makeText(context, getString(R.string.typePlayerName),
                    Toast.LENGTH_SHORT).show()
            }else {
                val player = playerName?.text.toString()
                findNavController().navigate(R.id.action_registerUserFragment_to_throwDiceFragment,
                bundleOf("playerName" to player))
            }
        }

        return binding?.root
    }
}
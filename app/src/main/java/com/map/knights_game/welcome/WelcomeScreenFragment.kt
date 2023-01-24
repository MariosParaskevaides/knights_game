package com.map.knights_game.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.map.knights_game.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {
    private lateinit var welcomeBinding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        welcomeBinding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        setupListeners()


        return welcomeBinding.root
    }

    private fun setupListeners() {

        welcomeBinding.startTheGame.setOnClickListener { _ ->

            var dimension: Int = 0

            if (!welcomeBinding.editText.text.isNullOrBlank()) {
                dimension = welcomeBinding.editText.text.toString().toInt()
            }

            val action = WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToGameFragment(dimension)
            findNavController().navigate(action)
        }
    }

}
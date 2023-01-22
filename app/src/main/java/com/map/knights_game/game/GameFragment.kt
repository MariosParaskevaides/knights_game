package com.map.knights_game.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.map.knights_game.databinding.FragmentTheGameBinding

class GameFragment : Fragment() {

    private lateinit var gameBinding: FragmentTheGameBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        gameBinding = FragmentTheGameBinding.inflate(inflater, container, false)

        return gameBinding.root

    }

}
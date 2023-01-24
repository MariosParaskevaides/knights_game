package com.map.knights_game.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.map.knights_game.ChessBoardView
import com.map.knights_game.databinding.FragmentTheGameBinding

class GameFragment : Fragment() {

    private val args: GameFragmentArgs by navArgs()
    private lateinit var gameBinding: FragmentTheGameBinding
//    private var gameViewModel: GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        gameBinding = FragmentTheGameBinding.inflate(inflater, container, false)
//        gameBinding.gameViewModel = gameViewModel
//        gameBinding.lifecycleOwner = viewLifecycleOwner
//        gameViewModel._dimension.value = args.dimension

//        return super.onCreateView(inflater, container, savedInstanceState)


        return gameBinding.root
    }


}
package com.examples.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRed.setOnClickListener { onClickRed() }
        buttonBlue.setOnClickListener { onClickBlue() }
        buttonNewActivity.setOnClickListener { onClickNewActivity() }
        buttonToolbar.setOnClickListener { onClickToolbar() }
    }

    /**
     * Navigate the host to the correct destination with required argument values
     */
    private fun onClickRed() {
        val action = MainFragmentDirections.actionMainFragmentToDisplayFragment()
        action.colour = "RED"
        findNavController().navigate(action)
    }

    private fun onClickBlue() {
        val action = MainFragmentDirections.actionMainFragmentToDisplayFragment()
        action.colour = "BLUE"
        findNavController().navigate(action)
    }

    /**
     * Launch a new activity with required argument values
     */
    private fun onClickNewActivity() {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToDisplayActivity())
    }

    /**
     * Launch a new fragment with it's own custom toolbar
     */
    private fun onClickToolbar() {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToDisplayFragmentWithActionBar())
    }

}

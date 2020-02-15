package com.examples.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.activity.addCallback
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.examples.navigation.R
import kotlinx.android.synthetic.main.fragment_display_fragment_with_action_bar.*

class DisplayFragmentWithActionBar : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_display_fragment_with_action_bar, container, false)
        setupBackNavigationCallback()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar()
    }

    /**
     * Support pressing of the back button using navigation including any custom callbacks (see setupBackNavigationCallback)
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Set up an action bar with support for navigating the back stack
     */
    private fun setupActionBar() {
        setHasOptionsMenu(true)

        val hostActivity = requireActivity() as AppCompatActivity
        hostActivity.setSupportActionBar(toolbar)
        hostActivity.setupActionBarWithNavController(findNavController())

        val actionBar = hostActivity.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)
    }

    /**
     * Set up a call back to save when the back navigation is triggered
     */
    private fun setupBackNavigationCallback() {
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            showBackStackMessage()
            findNavController().popBackStack()
        }
        callback.isEnabled = true
    }

    /**
     * Display a simple message
     */
    private fun showBackStackMessage() {
        val toast = Toast.makeText(context, "Successfully navigated the back stack", Toast.LENGTH_SHORT)
        toast.show()
    }
}

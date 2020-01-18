package com.baileytye.navcomponentdemo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.baileytye.navcomponentdemo.R
import com.baileytye.navcomponentdemo.User
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSend.setOnClickListener {
            val directions = DashboardFragmentDirections.actionNavigationDashboardToUserNestedGraph(
                User(
                    firstName = editTextFirstName.text.toString(),
                    lastName = editTextLastName.text.toString()
                )
            )
            findNavController().navigate(directions)
        }
    }
}

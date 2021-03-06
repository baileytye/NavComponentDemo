package com.baileytye.navcomponentdemo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.baileytye.navcomponentdemo.R
import kotlinx.android.synthetic.main.fragment_first_name.*

/**
 * A simple [Fragment] subclass.
 */
class FirstNameFragment : Fragment() {

    private val args : FirstNameFragmentArgs by navArgs()
    private val viewModel: UserViewModel by navGraphViewModels(R.id.userNestedGraph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewFirstName.text = args.firstName
    }
}

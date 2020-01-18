package com.baileytye.navcomponentdemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.baileytye.navcomponentdemo.R
import kotlinx.android.synthetic.main.fragment_home_second.*

class HomeSecondFragment : Fragment() {

    private val args: HomeSecondFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewReceived.text = getString(R.string.hello_home_second, args.myArg)
    }
}

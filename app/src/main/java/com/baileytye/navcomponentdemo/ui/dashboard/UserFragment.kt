package com.baileytye.navcomponentdemo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.baileytye.navcomponentdemo.R
import kotlinx.android.synthetic.main.fragment_user.*


class UserFragment : Fragment() {

    private val args: UserFragmentArgs by navArgs()
    private val viewModel: UserViewModel by navGraphViewModels(R.id.userNestedGraph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSendFirstName.setOnClickListener {
            val directions =
                UserFragmentDirections.actionUserFragmentToFirstNameFragment(args.user.firstName)
            findNavController().navigate(directions)
        }

        textViewUser.text = args.user.toString()
    }
}

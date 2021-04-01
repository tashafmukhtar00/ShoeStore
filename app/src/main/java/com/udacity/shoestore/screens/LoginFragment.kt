package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)


        binding.buttonSignIn.setOnClickListener {

            requireView().findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        }

        binding.buttonSignUp.setOnClickListener {
            requireView().findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        }

        return binding.root
    }


}
package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


//Shoe Name, Company, Shoe Size and Description
//A Cancel button with an action to navigate back to the shoe list screen
//A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model.


class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)




        binding.buttonCancel.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment))



        binding.apply {

            shoeData = Shoe()
            shoeViewModel = viewModel
        }


//        binding.buttonSave.setOnClickListener {
//            val shoeName = binding.editTextShoeName.text.toString()
//            val companyName = binding.editTextCompanyName.text.toString()
//            val shoeSize = binding.editTextSize.text.toString().toDouble()
//            val shoeDescription = binding.editTextDescription.text.toString()
//
//            val myShoe = Shoe(shoeName, shoeSize, companyName, shoeDescription)
//            viewModel.addShoe(myShoe)
//
//
//        }
        viewModel.dataAddedEvent.observe(viewLifecycleOwner, {
            if (it) {
                this.findNavController().navigateUp()

            }
        })

        return binding.root
    }


}
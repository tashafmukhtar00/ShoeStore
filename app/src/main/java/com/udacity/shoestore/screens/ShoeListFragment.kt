package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeView
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeViewBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    private lateinit var shoeView: ShoeView
    private lateinit var showData: Shoe


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        //  viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.apply {
            shoeViewModel = viewModel
            showData = Shoe()

        }

        shoeView = ShoeView(requireContext())
        viewModel.shoeList.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {

                for (shoe in it) {



                    val layout = ShoeViewBinding.inflate(inflater)
                    layout.shoeData = shoe
                    binding.showListView.addView(layout.root)

                }


            }

        })

        binding.addShoeButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))


        setHasOptionsMenu(true)
        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)
    }
}

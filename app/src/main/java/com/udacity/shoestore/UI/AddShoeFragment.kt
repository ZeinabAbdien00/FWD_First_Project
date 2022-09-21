package com.udacity.shoestore.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.viewModel.MainViewModel
import com.udacity.shoestore.databinding.FragmentAddShoeBinding


class AddShoeFragment : Fragment() {

    lateinit var binding : FragmentAddShoeBinding
    private val viewModel1 : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_add_shoe, container, false)

        binding.addShoeToViewModel = viewModel1
        viewModel1.Clear()

        binding.saveBtn.setOnClickListener(){

            val inCome : Boolean =viewModel1.callingAddNewShoe()

            if (inCome) {
                Toast.makeText(context, "Shoe is saved successfully !!", Toast.LENGTH_SHORT).show()
                it.findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)

            } else {
                Toast.makeText(context, "Enter All Data !!", Toast.LENGTH_LONG).show()
            }
        }
        binding.cancelBtn.setOnClickListener(){
            it.findNavController().navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }
        return binding.root
    }
}
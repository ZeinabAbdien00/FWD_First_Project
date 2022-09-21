package com.udacity.shoestore.UI

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.viewModel.MainViewModel
import com.udacity.shoestore.databinding.CardBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    private lateinit var binding : FragmentShoeListBinding
    private val viewModel : MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_shoe_list , container , false)
        setHasOptionsMenu(true)

        viewModel.shoeCall.observe(viewLifecycleOwner) {
            for (shoe in it) {
                addItemView(shoe)
            }
        }

        binding.addNewShoe.setOnClickListener(){
            it.findNavController().navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }

        return binding.root
    }

    private fun addItemView(shoe: Shoe) {
        val itemReturnBinding: CardBinding = CardBinding.inflate(layoutInflater)
        itemReturnBinding.addShoeItem = shoe
        val finalBinding = itemReturnBinding.root
        binding.linearCardViews.addView(finalBinding)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.my_menu , menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.log_out -> { view?.findNavController()?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())}
        }
        return super.onOptionsItemSelected(item)
    }
}
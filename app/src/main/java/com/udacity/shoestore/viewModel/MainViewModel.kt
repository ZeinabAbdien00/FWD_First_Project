package com.udacity.shoestore.viewModel

import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class MainViewModel: ViewModel() {

    private val shoeListItems = MutableLiveData<MutableList<Shoe>>()

    var itemName: String = ""
    var itemDescription: String = ""
    var itemSize: String = ""
    var itemCompany: String = ""

    init {
        shoeListItems.value = mutableListOf()
    }

    val shoeCall: LiveData<MutableList<Shoe>>
        get() = shoeListItems

    fun Clear() {
    itemName = ""
    itemDescription = ""
    itemSize = ""
    itemCompany = ""
    }

    private fun addNewShoe(name: String, size: Double, company: String, description: String) {
        val newShoeToAdd = Shoe(name, size, company, description,)
        shoeListItems.value!!.add(newShoeToAdd)
        Log.i("viewModelItemSaved", "shoe is saved to items")
    }


    fun callingAddNewShoe(): Boolean {
        var data : Boolean = dataEntered()
        when(data){
            true -> addNewShoe(itemName, itemSize.toDouble(), itemCompany, itemDescription)
            false -> false
        }
        return data
    }

    fun dataEntered(): Boolean {
        if (itemName.isBlank() || itemCompany.isBlank() || itemDescription.isBlank() || itemSize.isBlank())
        { return false }

        return true
    }

}
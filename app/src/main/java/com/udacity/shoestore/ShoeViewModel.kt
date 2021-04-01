package com.udacity.shoestore

import com.udacity.SingleLiveEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel() : ViewModel() {


    var dataAddedEvent = SingleLiveEvent<Boolean>()


    private val _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList



    init {

    }

    fun addShoe(myShoe: Shoe) {
        _shoeList.value?.add(myShoe)
        dataAddedEvent.value = true
    }
}
package com.composeui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composeui.model.Person
import com.composeui.model.PersonRepository
import kotlinx.coroutines.launch

class PersonMainScreenViewModel : ViewModel() {
    private val petRepository = PersonRepository()
    private val petLiveData = MutableLiveData<List<Person>>()
    val petsData: LiveData<List<Person>>
        get() = petLiveData

    init {
        viewModelScope.launch {
            petLiveData.value = petRepository.getPersonsList()
        }
    }
}
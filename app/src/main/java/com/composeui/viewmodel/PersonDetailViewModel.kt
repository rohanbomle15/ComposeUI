package com.composeui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composeui.model.Person
import com.composeui.model.PersonRepository
import kotlinx.coroutines.launch

class PersonDetailsViewModel : ViewModel() {

    private val petRepository = PersonRepository()
    private val petLiveData = MutableLiveData<Person>()
    val personData: LiveData<Person>
        get() = petLiveData

    fun loadPetInfo(petId: String) {
        viewModelScope.launch {
            petLiveData.value = petRepository.getPersonById(petId)
        }
    }
}
package com.beuni.roomdbimpl.viewmodel

import androidx.lifecycle.*
import com.beuni.roomdbimpl.db.ContactRepository
import com.beuni.roomdbimpl.db.Contacts
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ContactViewModel(private val contactRepository: ContactRepository) : ViewModel() {

    val allContacts: LiveData<List<Contacts>> = contactRepository.getAllContacts.asLiveData()

    fun insert(contact: Contacts)= viewModelScope.launch {
        contactRepository.insertContact(contact)
    }
}

class ContactViewModelFactory(private val contactRepository: ContactRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ContactViewModel(contactRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}
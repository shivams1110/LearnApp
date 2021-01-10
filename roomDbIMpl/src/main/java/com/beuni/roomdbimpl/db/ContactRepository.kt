package com.beuni.roomdbimpl.db

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val contactDao: ContactDao) {

    val getAllContacts: Flow<List<Contacts>> = contactDao.getAllContact()


    @WorkerThread
    suspend fun insertContact(contact: Contacts) {
        contactDao.insert(contact)
    }

}
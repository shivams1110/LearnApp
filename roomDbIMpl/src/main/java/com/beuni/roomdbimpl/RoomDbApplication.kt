package com.beuni.roomdbimpl

import android.app.Application
import com.beuni.roomdbimpl.db.ContactRepository
import com.beuni.roomdbimpl.db.ContactRoomDatabase

class RoomDbApplication : Application() {

    val database by lazy { ContactRoomDatabase.getInstance(this) }
    val repository by lazy { ContactRepository(database.contactDao()) }

}
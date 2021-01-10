package com.beuni.roomdbimpl.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Insert
    suspend fun insert(contacts: Contacts)

    @Query("SELECT * FROM Contacts")
    fun getAllContact(): Flow<List<Contacts>>


}
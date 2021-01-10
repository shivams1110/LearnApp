package com.beuni.roomdbimpl.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contacts(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "mobile_number") val mobileNumber: String

){
    constructor(name: String, mobileNumber: String): this(0, name, mobileNumber)
}
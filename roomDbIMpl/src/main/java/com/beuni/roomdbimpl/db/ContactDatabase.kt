package com.beuni.roomdbimpl.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executor

@Database(entities = [Contacts::class], version = 1)
abstract class ContactRoomDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object{

        @Volatile private var INSTANCE: ContactRoomDatabase?=null

        fun getInstance(context: Context): ContactRoomDatabase = INSTANCE ?: synchronized(this){
            INSTANCE ?: buildDataBase(context).also{ INSTANCE = it}
        }

        private fun buildDataBase(context: Context) = Room.databaseBuilder(context.applicationContext,
        ContactRoomDatabase::class.java,"contact_db")
            .addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)

                }
            })
            .build()


    }

}
package com.example.quoraapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase(){
    abstract fun contactDao() : ContactDao
    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabse(context : Context):ContactDatabase{

            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, ContactDatabase::class.java, "contactDB")
                            .build()
                }

            }
            return INSTANCE!!
        }
    }

}
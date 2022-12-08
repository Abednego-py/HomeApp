package com.example.homeapp.ui.welcome.notifications.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Search::class], version = 1)
abstract class SearchDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao


    companion object {
        @Volatile
        private var INSTANCE: SearchDatabase? = null
        fun getDatabase(context: Context): SearchDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SearchDatabase::class.java,
                    "search_database"
                )
//                    .createFromAsset("data/note.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }

}
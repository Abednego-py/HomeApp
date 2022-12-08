package com.example.homeapp.ui.welcome.notifications.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(item: Search)

    @Query("select * from Search")
    fun getSearchItems(): Flow<List<Search>>

    @Query("SELECT * from Search WHERE id = :id")
    fun getSearch(id: Int): Flow<Search>
}
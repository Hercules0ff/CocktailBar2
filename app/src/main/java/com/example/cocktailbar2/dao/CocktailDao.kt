package com.example.cocktailbar2.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cocktailbar2.entities.Cocktails

@Dao
interface CocktailDao {

    @get:Query("SELECT * FROM Cocktails ORDER BY id DESC")
    val allCocktails: List<Cocktails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCocktail(cocktails: Cocktails)

    @Delete
    fun deleteCocktail(cocktails: Cocktails)
}
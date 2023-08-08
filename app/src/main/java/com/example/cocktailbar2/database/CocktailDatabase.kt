package com.example.cocktailbar2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cocktailbar2.dao.CocktailDao
import com.example.cocktailbar2.entities.Cocktails

@Database(entities = [Cocktails::class], version = 1, exportSchema = false)
abstract class CocktailDatabase: RoomDatabase() {

    companion object{

        var cocktailDatabase: CocktailDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): CocktailDatabase{
            if (cocktailDatabase != null){
                cocktailDatabase = Room.databaseBuilder(
                    context,
                    CocktailDatabase::class.java,
                    "cocktail.db"
                ).build()
            }
            return cocktailDatabase!!
        }
    }

    abstract fun cocktailDao(): CocktailDao
}
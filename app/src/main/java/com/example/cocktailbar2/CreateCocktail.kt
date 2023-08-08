package com.example.cocktailbar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.cocktailbar2.database.CocktailDatabase
import com.example.cocktailbar2.databinding.ActivityCreateCocktailBinding
import com.example.cocktailbar2.databinding.ActivityHomeBinding
import com.example.cocktailbar2.entities.Cocktails
import kotlinx.coroutines.launch

class CreateCocktail : AppCompatActivity() {

    private lateinit var binding: ActivityCreateCocktailBinding
    private lateinit var database: CocktailDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCocktailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        database = CocktailDatabase.getDatabase(this)
        with(binding) {
            cancelBtn.setOnClickListener{
                onBackPressed()
            }
            saveBtn.setOnClickListener {
                saveCocktail()
            }
        }
    }

    fun saveCocktail() {
        if (binding.cocktailNameEt.text.isBlank()) {
            Toast.makeText(this, "Cocktail title can't be empty", Toast.LENGTH_SHORT).show()
            return
        }

        val cocktail = Cocktails(
            cocktailName = binding.cocktailNameEt.toString(),
            cocktailDescription = binding.cocktailDescriptionEt.toString(),
            cocktailReceipt = binding.cocktailRecipeEt.toString()
        )

        lifecycleScope.launch {
            val insertedId = database.cocktailDao().insertCocktail(cocktail)
            Toast.makeText(this@CreateCocktail, "Cocktail saved with ID $insertedId", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
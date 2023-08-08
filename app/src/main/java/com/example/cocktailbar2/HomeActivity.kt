package com.example.cocktailbar2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailbar2.adapter.CocktailAdapter
import com.example.cocktailbar2.entities.Cocktails
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    var cocktailsArr = ArrayList<Cocktails>()
    var cocktailAdapter = CocktailAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageAddCocktail = findViewById<FloatingActionButton>(R.id.plusButton)
        imageAddCocktail.setOnClickListener {
            startActivity(Intent(applicationContext, CreateCocktail::class.java))
        }

        cocktailsArr.add(Cocktails(1, "Mojito"))
        cocktailsArr.add(Cocktails(2, "Oramge"))
        cocktailsArr.add(Cocktails(3, "Dasl"))
        cocktailsArr.add(Cocktails(4, "Fresa"))

        cocktailAdapter.setData(cocktailsArr)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_cocktails)
        recyclerView.adapter = cocktailAdapter

    }
}
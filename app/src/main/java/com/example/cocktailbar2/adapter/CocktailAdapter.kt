package com.example.cocktailbar2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailbar2.R
import com.example.cocktailbar2.entities.Cocktails

class CocktailAdapter: RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {

    var cocktailList = ArrayList<Cocktails>()
    class CocktailViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    fun setData(arrData: List<Cocktails>){
        cocktailList = arrData as ArrayList<Cocktails>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        return CocktailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder
            .itemView
            .findViewById<TextView>(R.id.tv_cocktail_name)
            .text = cocktailList[position].cocktailName
    }
}
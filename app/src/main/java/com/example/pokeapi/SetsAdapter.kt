package com.example.pokeapi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonmvvm.Cards
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardsrows.view.*
import kotlinx.android.synthetic.main.sets_detail.view.*

class SetsAdapter(val SetsAPI: Json4Kotlin_BaseSets): RecyclerView.Adapter<SetsVH>(){

    //Number of items
    override fun getItemCount(): Int {
        return  SetsAPI.sets.size
    }
    //On create view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetsVH {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.sets_detail, parent,
            false)
        return SetsVH(cellForRow)
    }

    override fun onBindViewHolder(holder: SetsVH, position: Int) {
        // val pokeTitles = pokeTitles.get(position)
        val Sets = SetsAPI.sets.get(position)
        holder.view.txtDate.text = "Release Date: " + Sets.releaseDate
        holder.view.txtStandard.text = "Standard Legal: " + Sets.standardLegal
        holder.view.txtTotal.text = "Total Cards: " + Sets.totalCards
        val thumbnail = holder?.view?.imgSet
        Picasso.get().load(SetsAPI.sets.get(position).logoUrl).into(thumbnail)

        holder?.sets = Sets

    }
}

class SetsVH(val view: View, var sets: Sets? = null): RecyclerView.ViewHolder(view){

    companion object{
        val code = "ptcgo"
        val name = "setName"
    }

    init {
        view.setOnClickListener {
            println("Test")
            val intent = Intent(view.context, LstCardsActivity::class.java)
            intent.putExtra(code, sets?.code)
            intent.putExtra(name, sets?.name)
            view.context.startActivity(intent)
        }
    }

}
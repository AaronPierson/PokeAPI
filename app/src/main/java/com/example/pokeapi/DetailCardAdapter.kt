package com.example.pokeapi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonmvvm.Json4Kotlin_Base
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_row.view.*

class DetailCardAdapter(val CardAPI: Json4Kotlin_Base): RecyclerView.Adapter<DetailVH>(){
    override fun getItemCount(): Int {
        return  1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailVH {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.detail_row, parent,
            false)
        return DetailVH(cellForRow)
    }

    override fun onBindViewHolder(holder: DetailVH, position: Int) {
        // val pokeTitles = pokeTitles.get(position)
      //  val cardName = CardAPI.card.name
      //  holder?.view?.txtPokeName?.text = "Name: " + cardName
      //  holder?.view?.txtHP?.text = "HP: " + BaseAPI.card.hp.toString()
        val thumbnail = holder?.view?.imgPokeDetail
        Picasso.get().load(CardAPI.card.imageUrlHiRes).into(thumbnail);
    }

}

class DetailVH(val view: View): RecyclerView.ViewHolder(view){
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CardDetailActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}


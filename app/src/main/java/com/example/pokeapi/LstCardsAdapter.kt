package com.example.pokeapi

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonmvvm.Card
import com.example.pokemonmvvm.Cards
import com.example.pokemonmvvm.Json4Kotlin_BaseList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardsrows.view.*
import kotlinx.android.synthetic.main.detail_row.*
import kotlinx.android.synthetic.main.detail_row.view.*
import java.util.jar.Attributes

class LstCardsAdapter(val CardsAPI: Json4Kotlin_BaseList): RecyclerView.Adapter<CardsVH>(){

    override fun getItemCount(): Int {
        return  CardsAPI.cards.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsVH {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardsrows, parent,
            false)
        return CardsVH(cellForRow)
    }

    override fun onBindViewHolder(holder: CardsVH, position: Int) {
        // val pokeTitles = pokeTitles.get(position)
        val Cards = CardsAPI.cards.get(position)
        holder?.view?.txtArt?.text = "Artist Name: " + CardsAPI.cards.get(position).artist
        holder?.view?.txtRarity?.text = "Rarity: " + CardsAPI.cards.get(position).rarity
        holder?.view?.txtSeries?.text = "Series: " + CardsAPI.cards.get(position).series
        holder?.view?.txtSet?.text = "Set: " + CardsAPI.cards.get(position).set
        val thumbnail = holder?.view?.imgCardThumb
        Picasso.get().load(CardsAPI.cards.get(position).imageUrl).into(thumbnail)

        holder?.cards = Cards

    }


}

class CardsVH(val view: View, var cards: Cards? = null): RecyclerView.ViewHolder(view){

    companion object{
        val CardNameKey = "CardName"
        val CardID = "id"
        val url = "card_url"

    }

    init {
        view.setOnClickListener {
            println("Test")
            val intent = Intent(view.context, CardDetailActivity::class.java)
            intent.putExtra(CardNameKey, cards?.name)
            intent.putExtra(CardID, cards?.id)
            intent.putExtra(url, cards?.imageUrl)
            view.context.startActivity(intent)
        }
    }

}
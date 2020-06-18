package com.example.pokeapi

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonmvvm.Json4Kotlin_Base
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.detail_activity.*
import okhttp3.*
import java.io.IOException

class CardDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        setContentView(R.layout.detail_activity)
        rcyDetail.layoutManager = LinearLayoutManager(this)

        //change nav bar
        val nav_title = intent.getStringExtra(CardsVH.CardNameKey)
        val poke_id = intent.getStringExtra(CardsVH.CardID)
        val url = intent.getStringExtra(CardsVH.url)
        supportActionBar?.title = nav_title

        fetchDetialJson(poke_id)

    }

    fun fetchDetialJson(id: String? = ""){
       
        var  url = "https://api.pokemontcg.io/v1/cards/$id"

        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                println(body)
                val gson = GsonBuilder().create()
                val card = gson.fromJson(body, Json4Kotlin_Base::class.java)
                runOnUiThread {
                    rcyDetail.adapter = DetailCardAdapter(card)
                }
            }



            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute")
            }
        })
    }
}
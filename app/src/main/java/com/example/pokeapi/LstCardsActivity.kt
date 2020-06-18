package com.example.pokeapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonmvvm.Json4Kotlin_BaseList
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class LstCardsActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcyCards.layoutManager = LinearLayoutManager(this)
        val nav_title = intent.getStringExtra(SetsVH.name)
        val code = intent.getStringExtra(SetsVH.code)
        supportActionBar?.title = nav_title
        fetchlstJson(code)
    }

    fun fetchlstJson(code: String? = ""){

        // val url = "https://api.pokemontcg.io/v1/cards?setCode=swsh2"
        val url = "https://api.pokemontcg.io/v1/cards?setCode=$code"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                println(body)
                val gson = GsonBuilder().create()
                val cards = gson.fromJson(body, Json4Kotlin_BaseList::class.java)
                runOnUiThread {
                    rcyCards.adapter = LstCardsAdapter(cards)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                println("Failed to execute")
            }
        })
    }
}
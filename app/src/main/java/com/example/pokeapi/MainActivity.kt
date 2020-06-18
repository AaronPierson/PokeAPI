package com.example.pokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonmvvm.Json4Kotlin_BaseList
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.set_lst.*
import okhttp3.*
import java.io.IOException
//StartUp Code
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_lst)
        rcySets.layoutManager = LinearLayoutManager(this)
         fetchsetsJson()

    }
//Loading sets
    fun fetchsetsJson(){

        val url = "https://api.pokemontcg.io/v1/sets"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body?.string()
                println(body)
                val gson = GsonBuilder().create()
                val sets = gson.fromJson(body, Json4Kotlin_BaseSets::class.java)
                runOnUiThread {
                    rcySets.adapter = SetsAdapter(sets)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                println("Failed to execute")
            }
        })
    }



}
package com.example.pokeapi

import com.google.gson.annotations.SerializedName

data class Json4Kotlin_BaseSets (

    @SerializedName("sets") val sets : List<Sets>
)

data class Sets (

    @SerializedName("code") val code : String,
    @SerializedName("ptcgoCode") val ptcgoCode : String,
    @SerializedName("name") val name : String,
    @SerializedName("series") val series : String,
    @SerializedName("totalCards") val totalCards : Int,
    @SerializedName("standardLegal") val standardLegal : Boolean,
    @SerializedName("expandedLegal") val expandedLegal : Boolean,
    @SerializedName("releaseDate") val releaseDate : String,
    @SerializedName("symbolUrl") val symbolUrl : String,
    @SerializedName("logoUrl") val logoUrl : String,
    @SerializedName("updatedAt") val updatedAt : String
)
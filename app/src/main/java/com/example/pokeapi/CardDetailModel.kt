package com.example.pokemonmvvm

import com.google.gson.annotations.SerializedName

data class Json4Kotlin_Base (

    @SerializedName("card") val card : Card
)

data class Card (

    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("nationalPokedexNumber") val nationalPokedexNumber : Int,
    @SerializedName("imageUrl") val imageUrl : String,
    @SerializedName("imageUrlHiRes") val imageUrlHiRes : String
//    @SerializedName("types") val types : List<String>,
//    @SerializedName("supertype") val supertype : String,
//    @SerializedName("subtype") val subtype : String,
//    @SerializedName("ability") val ability : Ability,
//    @SerializedName("hp") val hp : Int,
//    @SerializedName("retreatCost") val retreatCost : List<String>,
//    @SerializedName("convertedRetreatCost") val convertedRetreatCost : Int,
//    @SerializedName("number") val number : Int,
//    @SerializedName("artist") val artist : String,
//    @SerializedName("rarity") val rarity : String,
//    @SerializedName("series") val series : String,
//    @SerializedName("set") val set : String,
//    @SerializedName("setCode") val setCode : String,
//    @SerializedName("attacks") val attacks : List<Attacks>,
//    @SerializedName("weaknesses") val weaknesses : List<Weaknesses>
)

//data class Ability (
//
//    @SerializedName("name") val name : String,
//    @SerializedName("text") val text : String,
//    @SerializedName("type") val type : String
//)
//
//data class Attacks (
//
//    @SerializedName("cost") val cost : List<String>,
//    @SerializedName("name") val name : String,
//    @SerializedName("text") val text : String,
//    @SerializedName("damage") val damage : Int,
//    @SerializedName("convertedEnergyCost") val convertedEnergyCost : Int
//)
//
//data class Weaknesses (
//
//    @SerializedName("type") val type : String,
//    @SerializedName("value") val value : String
//)
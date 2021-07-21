package com.example.kotlinreseno

import com.google.gson.annotations.SerializedName

class Country
{
    @SerializedName("name")
    var CountryName: String = ""

    @SerializedName("population")
    var CountryPopulation: String = ""

    @SerializedName("area")
    var CountryArea: String = ""

   @SerializedName("flag")
    var CountryFlag: String = ""


}


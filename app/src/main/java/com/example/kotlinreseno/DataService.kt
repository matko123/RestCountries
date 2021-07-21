package com.example.kotlinreseno

import retrofit2.Call
import retrofit2.http.GET

interface DataService
{
    @GET("region/europe")
    fun getAllCountries(): Call<List<Country>>

}
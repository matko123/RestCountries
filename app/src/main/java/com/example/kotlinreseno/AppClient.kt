package com.example.kotlinreseno
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClient
{

    var retrofit: Retrofit? = null

    companion object
    {
        const val BASE_URL = "https://restcountries.eu/rest/v2/"
        private lateinit var appClient: AppClient

        fun getInstance(): AppClient {
            if(!::appClient.isInitialized)
            {
                appClient = AppClient()

            }

            return appClient
        }
    }

    fun getService(): DataService? {
        if(retrofit == null)
        {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        return retrofit?.create(DataService::class.java)
    }

}

fun getApi(): DataService?
{
    return AppClient.getInstance().getService()
}
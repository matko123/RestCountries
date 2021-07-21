package com.example.kotlinreseno


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_click_me = findViewById(R.id.button3) as Button
        btn_click_me.setOnClickListener {
             generirajPodatke()
        }

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }

    private fun generirajPodatke() {
        val list = ArrayList<Model>()
        var sortedList: List<Model>

        val textDrzava = (findViewById(R.id.editText) as EditText)
        var textVelikost = (findViewById(R.id.editText2) as EditText)
        var textPopulacija = (findViewById(R.id.editText3) as EditText)

        getApi()?.getAllCountries()?.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>?, t: Throwable?) {}

            override fun onResponse(
                call: Call<List<Country>>?,
                response: Response<List<Country>>
            ) {

                response.body()?.forEach { country ->



                    if(country.CountryName.startsWith(textDrzava.text.toString().trim()) && country.CountryPopulation.startsWith(textVelikost.text.toString().trim()) && country.CountryArea.orEmpty().startsWith(textPopulacija.text.toString().trim()) )
                        {
                            val MojModel = Model(country.CountryName, country.CountryPopulation, country.CountryArea, country.CountryFlag)
                            list.add(MojModel)
                        }
                        else if(textDrzava.text.toString().isBlank()  && textVelikost.text.toString().isBlank() && textPopulacija.text.toString().isBlank())
                        {
                            val MojModel = Model(country.CountryName, country.CountryPopulation, country.CountryArea, country.CountryFlag)
                            list.add(MojModel)
                        }

                }

                sortedList = list.sortedWith(compareBy({ it.CountryPopulation?.toInt()?: 0  }))

                recycler_view.adapter = ExampleAdapter(sortedList, this@MainActivity)
            }
        })

    }
}

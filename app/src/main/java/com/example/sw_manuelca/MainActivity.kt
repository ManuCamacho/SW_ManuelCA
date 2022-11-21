package com.example.sw_manuelca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Toast
import com.example.sw_manuelca.Adapter.PersonajesAdapter
import com.example.sw_manuelca.Result
import com.example.sw_manuelca.databinding.ActivityMainBinding
import com.example.sw_manuelca.databinding.ItemPersonajeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  lateinit var  adapter: PersonajesAdapter
    private val personajes = mutableListOf<com.example.sw_manuelca.Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun searchByName(query:String)  {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<PersonajesResponse> = getRetrofit().create(APIService::class.java).getPersonajes("$query/images")
            val puppies = call.body()
            runOnUiThread{
                if(call.isSuccessful){

                    personajes.clear()
                    personajes.addAll(personajes)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
            }

        }
    }
    private fun initRecyclerView(){
        adapter  = PersonajesAdapter(personajes)



    }
    private fun showError(){
        Toast.makeText(this,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}
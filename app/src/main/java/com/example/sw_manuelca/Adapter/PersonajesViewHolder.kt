package com.example.sw_manuelca.Adapter

import android.media.Image
import android.provider.Settings.Global
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sw_manuelca.Personajes
import com.example.sw_manuelca.PersonajesResponse
import com.example.sw_manuelca.databinding.ItemPersonajeBinding

class PersonajesViewHolder (view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemPersonajeBinding.bind(view)

    fun bind (SWModel:com.example.sw_manuelca.Result){
        binding.nombre.text = SWModel.name
        binding.altura.text = SWModel.height




    }
}
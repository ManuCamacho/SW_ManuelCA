package com.example.sw_manuelca.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sw_manuelca.R

class PersonajesAdapter(val images: List<com.example.sw_manuelca.Result>): RecyclerView.Adapter<PersonajesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonajesViewHolder(layoutInflater.inflate(R.layout.item_personaje,parent,false))
    }

    override fun onBindViewHolder(holder: PersonajesViewHolder, position: Int) {
        val item:com.example.sw_manuelca.Result = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = images.size
}
package com.ruben.daigualapps.SuperheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ruben.daigualapps.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superhero: SuperheroItemResponse) {
        binding.tvSuperheroName.text = superhero.name
        Picasso.get().load("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/" + superhero.superheroId
                + "-" + superhero.name.lowercase().replace(" ","-")+".jpg")
            .into(binding.ivSuperhero);
    }
}

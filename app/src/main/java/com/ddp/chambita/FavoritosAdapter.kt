package com.ddp.chambita

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater


class FavoritosAdapter(private val favoritosList: MutableList<Trabajador>, private val context: Context): RecyclerView.Adapter<FavoritosViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoritosViewHolder(layoutInflater.inflate(R.layout.item_worker, parent, false), context)
    }

    override fun getItemCount(): Int = favoritosList.size

    override fun onBindViewHolder(holder: FavoritosViewHolder, position: Int) {
        val item = favoritosList[position]
        holder.render(item, favoritosList, this)
    }

}
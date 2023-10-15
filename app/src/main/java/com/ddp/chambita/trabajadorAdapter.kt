package com.ddp.chambita

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.navigation.NavController


class TrabajadorAdapter(private val trabajadorList:List<Trabajador>, private val context: Context, private val navController: NavController): RecyclerView.Adapter<TrabajadorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajadorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TrabajadorViewHolder(layoutInflater.inflate(R.layout.item_worker, parent, false), context)
    }
    override fun getItemCount(): Int = trabajadorList.size

    override fun onBindViewHolder(holder: TrabajadorViewHolder, position: Int) {
        val item = trabajadorList[position]
        holder.render(item, navController)
    }

}
package com.ddp.chambita

import android.view.View
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoritosViewHolder (view: View, private val context: Context):RecyclerView.ViewHolder(view){

    private val workerName = view.findViewById<TextView>(R.id.workerName)
    private val job = view.findViewById<TextView>(R.id.workerJob)
    private val picture = view.findViewById<ImageView>(R.id.worker_image)
    private val star1 = view.findViewById<ImageView>(R.id.star1)
    private val star2 = view.findViewById<ImageView>(R.id.star2)
    private val star3 = view.findViewById<ImageView>(R.id.star3)
    private val star4 = view.findViewById<ImageView>(R.id.star4)
    private val star5 = view.findViewById<ImageView>(R.id.star5)
    private val hearth = view.findViewById<ImageView>(R.id.hearth)

    //Imagenes de estrellas
    private val star = context.resources.getIdentifier("fullstar", "drawable", context.packageName)
    private val halfstar = context.resources.getIdentifier("starhalf", "drawable", context.packageName)
    private val nostar = context.resources.getIdentifier("nostar", "drawable", context.packageName)

    //corazones
    private val corazon = context.resources.getIdentifier("favoriteblue", "drawable", context.packageName)
    private val corazonlineal = context.resources.getIdentifier("favoritebaseline", "drawable", context.packageName)
    fun chooseStar(wstar: ImageView, cantidad: Double, i:Int){

        if (cantidad >= i) wstar.setImageResource(star)
        else if (cantidad > i-1) wstar.setImageResource(halfstar)
        else wstar.setImageResource(nostar)
    }
    fun render(worker: Trabajador, favoritosList: MutableList<Trabajador>, adapter: FavoritosAdapter) {
        workerName.text = worker.name
        job.text = worker.job

        //Imagen de perfil
        val resourceID = context.resources.getIdentifier(worker.username, "drawable", context.packageName)
        picture.setImageResource(resourceID)

        //Para elegir las imagenes de estrellas
        chooseStar(star1, worker.stars, 1)
        chooseStar(star2, worker.stars, 2)
        chooseStar(star3, worker.stars, 3)
        chooseStar(star4, worker.stars, 4)
        chooseStar(star5, worker.stars, 5)

        //elegir el corazon
        if (worker.favorito == 'y') hearth.setImageResource(corazon)
        else hearth.setImageResource(corazonlineal)

        hearth.setOnClickListener(){
            if (worker.favorito == 'y'){
                worker.favorito = 'n'
                hearth.setImageResource(corazonlineal)
                val index = favoritosList.indexOf(worker)
                if (index != -1){
                    favoritosList.removeAt(index)
                    adapter.notifyItemRemoved(index)
                }
            }
            else{
                worker.favorito = 'y'
                hearth.setImageResource(corazon)
            }
        }
    }
}
package com.ddp.chambita.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ddp.chambita.FavoritosAdapter
import com.ddp.chambita.R
import com.ddp.chambita.Trabajador
import com.ddp.chambita.databinding.FragmentFavoritosBinding
import com.ddp.chambita.workerExamples
import android.util.Log

class GalleryFragment : Fragment() {

    private var _binding: FragmentFavoritosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var favoritos = mutableListOf<Trabajador>()

    fun listaFavoritos(){

        favoritos.clear()

        for (trabajador in workerExamples.workerEx){

            if (trabajador.favorito == 'y'){
                favoritos.add(trabajador)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.favoritos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        listaFavoritos()
        recyclerView.adapter = FavoritosAdapter(favoritos, requireContext())

        galleryViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onResume(){
        super.onResume()
        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.favoritos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        listaFavoritos()
        recyclerView.adapter = FavoritosAdapter(favoritos, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
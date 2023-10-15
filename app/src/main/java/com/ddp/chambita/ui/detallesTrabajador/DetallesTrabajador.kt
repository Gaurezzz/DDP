package com.ddp.chambita.ui.detallesTrabajador

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
import com.ddp.chambita.databinding.FragmentDetallesTrabajadorBinding
import com.ddp.chambita.ui.home.HomeViewModel

class DetallesTrabajador : Fragment() {

    private var _binding: FragmentDetallesTrabajadorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val detallesViewModel =
            ViewModelProvider(this).get(DetallesViewModel::class.java)

        _binding = FragmentDetallesTrabajadorBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
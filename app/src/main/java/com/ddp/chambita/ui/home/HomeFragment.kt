package com.ddp.chambita.ui.home

import android.util.Log
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ddp.chambita.R
import com.ddp.chambita.TrabajadorAdapter
import com.ddp.chambita.databinding.FragmentHomeBinding
import com.ddp.chambita.workerExamples
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    var trabajadores = workerExamples.workerEx;

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.trabajadores)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TrabajadorAdapter(trabajadores, requireContext(), findNavController())


        return root
    }

    fun abrirDetalles (fragment: Fragment){
        val navController = this.findNavController()
        navController.navigate(R.id.detalles)
    }

    override fun onResume() {
        super.onResume()

        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.trabajadores)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TrabajadorAdapter(trabajadores, requireContext(), findNavController())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
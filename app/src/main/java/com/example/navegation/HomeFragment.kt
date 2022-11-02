package com.example.navegation

import android.os.Bundle
import android.text.Layout.Directions
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navegation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: Adapter

    val recetaListener =
        object : Adapter.RecetaListener {
            override fun onItemClick(receta: Receta) {
                val action = HomeFragmentDirections.actionHomeFragmentToRecetaDetailFragment(receta)
                findNavController().navigate(action)
            }

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerView()
    }

    fun initRecyclerView(){
        val recyclerView = binding.rvRecetas
        adapter = Adapter()

        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
        adapter.setRecetaListener(recetaListener)
        adapter.submitList(
            listOf(
                recetaLentejas,
                recetaGarbanzos,
                recetaPasta

            )
        )
    }


}
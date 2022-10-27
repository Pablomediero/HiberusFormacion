package com.example.navegation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navegation.databinding.ActivityMainBinding
import com.example.navegation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
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
        /*var tvReceta1: TextView = view.findViewById(R.id.recetas1)
        var tvReceta2: TextView = view.findViewById(R.id.recetas2)

        tvReceta1.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.receta1Fragment)

        }

        tvReceta2.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.receta2Fragment)

        }*/
        val recetaListener =
            object : Adapter.RecetaListener {
                override fun onItemClick(receta: Receta) {

                }

            }
        initRecyvlerView(view)
    }

    fun initRecyvlerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerRecetas)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = Adapter()
    }


}
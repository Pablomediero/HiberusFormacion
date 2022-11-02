package com.example.navegation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.navegation.databinding.FragmentHomeBinding
import com.example.navegation.databinding.FragmentRecetadetailBinding


class RecetaDetailFragment : Fragment() {
    private var _binding: FragmentRecetadetailBinding? = null
    private val binding get() = _binding!!
    val args: RecetaDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecetadetailBinding.inflate(
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

        val tvNombreReceta: TextView = binding.recetas1
        val tvInfoReceta: TextView = binding.infoReceta
        val tvIngredienteReceta: TextView = binding.ingredienteReceta
        val tvElaboracionReceta: TextView = binding.elaboracionReceta
        val ivUrlFoto: ImageView = binding.imagenReceta

        val nombreRecetaDato = args.receta.nombre
        val infoRecetaDato = args.receta.informacion
        val otrosRecetaDato = args.receta.elaboracion

        var aux = "Disponer de los siguientes: \n"
     /*   for(texto in args.receta.ingredientes){
            aux += " - " + texto + "\n"
        }
*/
        args.receta.ingredientes.forEach{ingrediente ->
            aux += " - " + ingrediente + "\n"

        }

        tvNombreReceta.text = nombreRecetaDato
        tvInfoReceta.text = infoRecetaDato
        tvIngredienteReceta.text = aux
        tvElaboracionReceta.text = otrosRecetaDato
        Glide.with(ivUrlFoto.context).load(args.receta.fotoUrl).into(ivUrlFoto)



    }
}
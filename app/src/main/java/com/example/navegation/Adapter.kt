package com.example.navegation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.navegation.databinding.ItemRecetaBinding


/*class Adapter(val listaRecetas:List<String>): RecyclerView.Adapter<RecetasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecetasViewHolder(layoutInflater.inflate(R.layout.item_receta, parent, false))
    }

    override fun getItemCount(): Int = listaRecetas.size

    override fun onBindViewHolder(holder: RecetasViewHolder, position: Int) {
        val item = listaRecetas[position]
        holder.render(item)
    }
}*/

var recetaPasta = Receta("Pasta", arrayListOf("Informacion","Ingredientes","Otros"));
var recetaLentejas = Receta("Lentejas", arrayListOf("Informacion","Ingredientes","Otros"));
var recetaGarbanzos = Receta("Garbanzos", arrayListOf("Informacion","Ingredientes","Otros"));
var datos = arrayListOf<Receta>(recetaPasta, recetaLentejas, recetaGarbanzos)
class Adapter: ListAdapter<Receta, Adapter.RecetaViewHolder>(
    object : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.nombre == newItem.nombre
        }

    }

){

    interface RecetaListener{
        fun onItemClick(receta: Receta)

    }

    private var recetaListener: RecetaListener? = null

    fun setRecetaListener(recetaListener: RecetaListener){
        this.recetaListener = recetaListener
    }

    inner class RecetaViewHolder(itemBinding: ItemRecetaBinding): ViewHolder(itemBinding.root){

        val binding = ItemRecetaBinding.bind(itemBinding.root)

        fun render(receta: Receta){
            binding.nombreReceta.text = receta.nombre
            binding.nombreReceta.setOnClickListener{
                Toast.makeText(it.context,binding.nombreReceta.text , Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {

    }
}
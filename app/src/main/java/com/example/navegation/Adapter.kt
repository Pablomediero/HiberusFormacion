package com.example.navegation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.navegation.databinding.ItemRecetaBinding


var recetaPasta = Receta("Pasta", arrayListOf("400g de macarrones", "3 dientes de ajo", "1 cebolla", "4 latillas de atún pequeñas", "1kg de tomate triturado"),"La pasta es un alimento que no falta en nuestra gastronomía. Hay mil maneras de preparar un plato de pasta y hasta los niños adoran este ingrediente.","Para elaborar la pasta, la semolina se mezcla con agua, (también se necesita huevo) para formar una pasta grumosa. La masa no está completamente formada hasta que no pasa por la cámara de mezclado hacia el extrusor.", "https://www.clara.es/medio/2022/07/10/espaguetis-a-la-bolonesa_83453f58_1280x1706.jpg")

var recetaLentejas = Receta("Lentejas", arrayListOf("500 g. de lentejas pardinas extra","4 zanahorias grandes", "2 dientes de ajo", "2 cebollas grandes","1 hoja de laurel"),"Hay platos tradicionales que nos transportan automáticamente a recuerdos familiares, y las legumbres son sin duda el mejor ejemplo. Pocas recetas hay más caseras que las lentejas guisadas, un clásico humilde que reconforta en días fríos pero que también disfrutamos todo el año, pues si las hacemos vegetarianas serán mucho más ligeras, sin perder sabor.","Picamos la cebolla, el ajo y el pimiento en trozos muy pequeños para que se vayan deshaciendo en la cocción. Al final de la cocción casi no notaremos textura de ninguno de los ingredientes pero sí su sabor. Como el ajo a muchas personas no les gusta encontrarlo en el plato, podéis echarlo entero y retirarlo a mitad de la cocción","https://recetinas.com/wp-content/uploads/2020/01/lentejas-con-chorizo.jpg")

var recetaGarbanzos = Receta("Garbanzos", arrayListOf("500 gramos de garbanzos cocidos.","1 hoja de laurel ","1 pastilla de caldo o una pizca de sal ","1 pimiento verde "),"Las recetas de garbanzos guisados son un clásico de muchas gastronomías, ya que constituyen un plato económico a la par que nutritivo, completo y cargado de energía","Pon los garbanzos a remojo la noche anterior en abundante agua, preferiblemente, templada. Si utilizas agua del grifo con mucha cal, agrega una cucharadita de bicarbonato de sodio","https://elmundoenrecetas.s3.amazonaws.com/uploads/recipe/picture/824/garbanzos_guisados_2.webp")

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
        val nombreReceta: TextView = itemBinding.tvRecetaNombre

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val itemBinding = ItemRecetaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecetaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val item = getItem(position)
        holder.nombreReceta.text = item.nombre

        holder.itemView.setOnClickListener{
            recetaListener?.onItemClick(item)
        }
    }
}
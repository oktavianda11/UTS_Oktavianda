package com.example.uts


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter(private val superheroList : ArrayList<Superhero>)
    : RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClikListener(listener: onItemClickListener){

        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero,
        parent, false)

        return SuperheroViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val currentItem = superheroList[position]
        holder.imageView.setImageResource(currentItem.imgSuperhero)
        holder.titleSuperhero.text = (currentItem.nameSuperhero)
        holder.descSuperhero.text = (currentItem.descSuperhero)
        holder.rateSuperhero.text = (currentItem.rateSuperhero)

    }

    class SuperheroViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.img_item_photo)
        val titleSuperhero : TextView = itemView.findViewById(R.id.tv_item_name)
        val descSuperhero : TextView = itemView.findViewById(R.id.tv_item_description)
        val rateSuperhero : TextView = itemView.findViewById(R.id.tv_item_rate)

        init {
            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }

}



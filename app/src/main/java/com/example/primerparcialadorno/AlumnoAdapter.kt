package com.example.primerparcialadorno

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlumnoAdapter(val context: Context) : ListAdapter<Alumno, AlumnoAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Alumno) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val nombre : TextView = view.findViewById(R.id.textViewAlumnoNombre)
        //private val edad: TextView = view.findViewById(R.id.textViewDetailAge)
        private val imagenAlumno: ImageView = view.findViewById(R.id.imageViewAlumno)

        fun bind (alumno: Alumno) {
            nombre.text = "nombre: " + alumno.name
            //edad.text = alumno.age

            Glide.with(context)
                .load(alumno.url)
                .into(imagenAlumno)

            view.setOnClickListener {
                onItemClickListener(alumno)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Alumno>() {
        override fun areItemsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return oldItem == newItem
        }
    }

}
package com.example.primerparcialadorno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AlumnoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = AlumnoAdapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(getListadoDeAlumnos())
        adapter.onItemClickListener = { alumno ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", alumno.name)
            intent.putExtra("age", alumno.age)
            intent.putExtra("url", alumno.url)
            startActivity(intent)
        }
/*
        val bundle = intent.extras

        val name = bundle?.getString("name","")
        val age = bundle!!.getInt("age")


        val listadoDeAlumnos : MutableList<Alumno> = mutableListOf(

            Alumno(4, "Juan",45,"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftwinfinite.net%2Fwp-content%2Fuploads%2F2019%2F11%2Fbulbasaur.jpg&f=1&nofb=1"),
            Alumno(2, "Pedro",60,"https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F11%2FShauna_Ivysaur-1180x664.png&f=1&nofb=1"),
            Alumno(3,"Lolo",80,"https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F11%2F951.png&f=1&nofb=1"),
        )

        val alumnoBindeo =  Alumno(1,name.toString(),age,"https://en.wikipedia.org/wiki/Bart_Simpson#/media/File:Bart_Simpson_200px.png")
        listadoDeAlumnos.add(alumnoBindeo)

        */



    }

    private fun getListadoDeAlumnos():MutableList<Alumno>? {


        val bundle = intent.extras

        val name = bundle?.getString("name","")
        val age = bundle?.getString("age")


        val listadoDeAlumnos : MutableList<Alumno> = mutableListOf(

            Alumno(4, "Juan","45","https://www.pngkit.com/png/full/277-2772461_img-0422-good-linkedin-profile-pics-for-men.png"),
            Alumno(2, "Gabriela","60","https://www.pngitem.com/pimgs/m/286-2868550_smiling-business-woman-png-transparent-png.png"),
            Alumno(3,"Romina","80","https://www.nicepng.com/png/detail/231-2318629_asian-business-woman-png-png.png"),
            Alumno(5,"Kate","44","https://mlt.org/wp-content/uploads/2015/11/narrative-section-challenge-woman.png"),
            Alumno(6,"Rita","32","https://s3.amazonaws.com/portalbanregio/assets/rediseno/lp/images/components/daniel-br.png"),
            Alumno(7,"Roberto","32","https://www.pngall.com/wp-content/uploads/8/Young-Man-PNG-Free-Image.png"),
            Alumno(8,"Pedro","20","https://simg.nicepng.com/png/small/408-4088927_rich-young-adult-reece-kidd-man.png"),
            Alumno(9,"Juan","37","https://us.123rf.com/450wm/gstockstudio/gstockstudio1610/gstockstudio161000144/64179555-hombre-de-negocios-seguro-joven-y-confiado-manteniendo-los-brazos-cruzados-y-mirando-a-cámara-por.jpg"),
            Alumno(10,"Ignacio","20","https://png.pngitem.com/pimgs/s/234-2348247_young-boy-png-transparent-png.png"),
        )

        val alumnoBindeo =  Alumno(1,name.toString(),age.toString(),"https://www.jaxsymphony.org/wp-content/uploads/2021/06/IMG_3885-ollarsaba.png")
        listadoDeAlumnos.add(alumnoBindeo)

        return listadoDeAlumnos

   }


}
package com.example.primerparcialadorno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var imageView : ImageView
    private lateinit var textViewDetailName : TextView
    private lateinit var textViewDetailAge : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imageView = findViewById(R.id.imageViewDetail)
        textViewDetailName = findViewById(R.id.textViewDetailName)
        textViewDetailAge = findViewById(R.id.textViewDetailAge)

        val bundle = intent.extras
        val nombre = bundle?.getString("name", "")
        val edad = bundle?.getString("age")
        val url = bundle?.getString("url") ?: ""

        textViewDetailName.text = nombre
        textViewDetailAge.text= "$edad Años"
        Glide.with(applicationContext)
            .load(url)
            .into(imageView)
    }


}
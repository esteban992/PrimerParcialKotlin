package com.example.primerparcialadorno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonToAction : Button
    private lateinit var textViewName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToAction = findViewById(R.id.buttonLogin)
        textViewName = findViewById(R.id.textViewNombre)

        // Traemos las Preferencias
        val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)

        // traemos la información que tenga guardada en preferences para la clave "name"
        // si no hay, es decir que no existe, que no traiga nada
        val userName = preferences.getString("name","")
        val userAge = preferences.getString("age","")


        if (userName != null){

            // si el userName está vacío, le cambiamos el texto al botón Continuar por "Registrar"
            if (userName.isEmpty()){
                buttonToAction.text = "Registrar"

                // le ponemos un listener, si está vacío, nos va a mandar a registrar
                buttonToAction.setOnClickListener{

                    // que nos lleve al actividad RegisterActivity
                    val intent = Intent(this,RegisterActivity::class.java)
                    startActivity(intent)
                }
            }else //si tiene un nombre guardado
            {
                buttonToAction.text = "Continuar"
                textViewName.text  = userName

                // vamos desde esta Activity a RecyclerActivity
                buttonToAction.setOnClickListener{
                    val intent = Intent(this,RecyclerViewActivity::class.java)
                    intent.putExtra("name",userName)
                    intent.putExtra("age",userAge)
                    startActivity(intent)
                }
            }
        }



    }

}
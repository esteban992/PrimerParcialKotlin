package com.example.primerparcialadorno

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var buttonContinueToLogin : Button
    private lateinit var editTextEnterName: EditText
    private lateinit var editTextEnterAge: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonContinueToLogin = findViewById(R.id.buttonToLogin)
        editTextEnterName = findViewById(R.id.editTextTextName)
        editTextEnterAge = findViewById(R.id.editTextTextAge)

        // Cada vez que se aprete el botón "Continue To Login"
        // que se grabe el contenido que hay en editTextEnterName
        // y lo guarde en la SharedPreference

        buttonContinueToLogin.setOnClickListener{
            if(editTextEnterName.text.isNullOrEmpty() || editTextEnterAge.text.isNullOrEmpty()){
                Toast.makeText(this, "Ingrese campos válidos", Toast.LENGTH_SHORT).show()
            }
            else{

                val userName = editTextEnterName.text.toString()
                val userAge  = editTextEnterAge.text.toString()

                // creamos una variable para guardar las preferencias.
                // Modo Privado para que nadie tenga acceso
                // Si no existe las crea
                val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)

                // guardamos las SharedPreferences
                val editor = preferences.edit()
                editor.putString("name",userName)
                editor.putString("age",userAge)

                editor.apply()

                // lleva la información desde ESTA Activity hasta, MainActivity
                val intent = Intent(this,MainActivity::class.java)

                startActivity(intent)
            }

        }

    }
}
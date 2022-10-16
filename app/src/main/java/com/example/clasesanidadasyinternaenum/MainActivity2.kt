package com.example.clasesanidadasyinternaenum

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.clasesanidadaseinternasenum.MainActivity
import com.example.clasesanidadaseinternasenum.R

class MainActivity2 : AppCompatActivity() {
    private var  lvLenguajes: ListView?=null
    private var tvSeleccion: TextView?=null
    private var Lenguajes = arrayOf("Kotlin", "C#", "Java", "C++", "Php", "Vb.Net")
    private val posiciones = arrayOf ("1", "2", "3", "4", "5", "6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        lvLenguajes = findViewById(R.id.Lv_Lenguajes)
        tvSeleccion=findViewById(R.id.Tv_Seleccion)


        var adaptador : ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.list_item_claseprogramacion, Lenguajes)
        lvLenguajes?.adapter=adaptador
        lvLenguajes?.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position:Int, id:Long
            ) {
                tvSeleccion?.text = "Posicion del lenguaje ${lvLenguajes?.getItemAtPosition(position)} es ${posiciones[position]}"

            }

        }
    }

    fun btn_Atras(Vista: View){
        val ventana2: Intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(ventana2)

    }
}
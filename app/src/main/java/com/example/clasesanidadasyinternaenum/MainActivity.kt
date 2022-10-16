//@Autor:Stephanie Rodriguez
package com.example.clasesanidadaseinternasenum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlin.jvm.internal.Intrinsics

class MainActivity : AppCompatActivity() {
    var TxtNumero1: EditText?=null
    lateinit var Txt_Numero2:EditText
    lateinit var V_Resultado:TextView
    lateinit var rb_Sumar:RadioButton
    lateinit var rb_Restar:RadioButton
    lateinit var rb_Multiplicar:RadioButton
    lateinit var rb_Dividir:RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ClaseEnumeradas()
        SeguridadNula()
        Funciones()
        Clases()
        ClaseAnidadaYInterna()
        ///View
        TxtNumero1 = findViewById(R.id.Txt_Numero1)
        Txt_Numero2 = findViewById(R.id.TXT_Numero2)
        V_Resultado = findViewById(R.id.V_Resultado)
        rb_Sumar = findViewById(R.id.rb_Sumar)
        rb_Restar = findViewById(R.id.rb_Restar)
        rb_Multiplicar = findViewById(R.id.rb_Multiplicar)
        rb_Dividir = findViewById(R.id.rb_Dividir)


    }
    //Enum class o clases enumeradas creacion de metodo
    enum class  Direccion (val dir:Int){
        //Definir variables
        NORTE(1),SUR(-1),ESTE(1),OESTE(-1);

        fun descripcion():String{
            return when (this){
                NORTE -> "La direccion es norte"
                SUR -> "La direccion es Sur"
                ESTE -> "La direccion es Este"
                OESTE -> "La direccion es Oeste"
            }
        }
    }

    private fun ClaseEnumeradas(){
        var DireccionUsuario:Direccion?=null
        println(DireccionUsuario)
        println("DIreccion Actual: $DireccionUsuario ")

        DireccionUsuario = Direccion.NORTE
        println("DIreccion Actual: $DireccionUsuario ")
        DireccionUsuario = Direccion.OESTE
        println("DIreccion Actual: $DireccionUsuario ")
        //Propiedades por def
        println("Propiedad Name: ${DireccionUsuario.name}")
        println("Propiedad Ordinal: ${DireccionUsuario.ordinal}")
    }
//Seguridad contra Nulas

    fun SeguridadNula(){
        var MiString = " Programacion IV (20/09/2022)"
        //MiString=Null Seria un error de compilacion
        println(MiString)

        var MiSeguridadNula:String?="Valor de seguridad nula"
        println(MiSeguridadNula)
        MiSeguridadNula=null
        println(MiSeguridadNula)

        MiSeguridadNula="Le volvemos a cambiar el valor"
        println(MiSeguridadNula)

        if(MiSeguridadNula!=null){
            println(MiSeguridadNula !!.toString())
        }else{
            println(MiSeguridadNula !!.toString())
        }
        //Llamadas seguras (Safe Call)
        println(MiSeguridadNula?.length)
        MiSeguridadNula?.let {
            println(it.toString())
        } ?: kotlin.run{
            println(MiSeguridadNula.toString())
        }
    }

    fun Funciones(){
        desirHola()
        desirHola()
        desirHola()
        desirHola()

        DecirNombre("Emerson")

        val resultadosuma= SumarDosNumeros(4,6)
        println(resultadosuma)
        println(SumarDosNumeros(3 , SumarDosNumeros (  7, 5  )))
        DecirNombreYEdad("Emerson",21)

    }
    //Funcion Simple
    fun desirHola(){
        println("Desir Hola")
    }

    fun DecirNombre (nombre:String) {
        println("Hola tu nombre es: ${nombre} ")
    }
    fun DecirNombreYEdad (nombre:String, edad:Int) {
        println("Hola tu nombre es: ${nombre} y mi edad es: $edad")
    }

    //Funciones con un valor de retorno
    fun SumarDosNumeros(num1:Int,num2:Int):Int{
        val Suma=num1+num2
        return Suma
    }

    fun Clases(){
        val Persona=Estudiantes("Emerson", 21, arrayOf(Estudiantes.Lenguaje.Java, ))
        println(Persona.Nombre)
        Persona.Edad = 22
        println(Persona.Edad)
        Persona.Codigo()

        val Persona2=Estudiantes("Gabriel", 22, arrayOf(Estudiantes.Lenguaje.PHP, ), arrayOf(Persona))
        println(Persona2.Nombre)
        Persona2.Edad = 22
        println(Persona2.Edad)
        Persona2.Codigo()

        println("${Persona2.amigo?.first()?.Nombre} Es amigo de ${Persona2.Nombre}:")

    }

    private fun ClaseAnidadaYInterna(){
        val miClaseAninada = MiClaseAninadaInterna.miClaseAninada()
        val sumar = miClaseAninada.suma(10,5)
        println ("El resultado de la suma es $sumar")

        val miClaseINterna = MiClaseAninadaInterna().miClaseINterna()
        val sumarDos = miClaseINterna.sumarUno(10)
        println ("El resultado de sumar uno es: $sumarDos")

        val sumarTres = miClaseINterna.sumarDos(5)
        println ("El resultado de sumar uno es: $sumarTres")
    }

    fun Calcular (Vista:View){
        val valor1_String=TxtNumero1?.text.toString()
        val Valor2_String = Txt_Numero2?.text.toString()

        val valor1_Int=valor1_String.toInt()//Converitr de string a int
        //Otra forma
        val valor2_Int=Integer.parseInt(Valor2_String)
        //Hacer la suma
        val suma = valor1_Int+valor2_Int
        val resultado = suma.toString()

        // V_Resultado.setText(resultado)

        if (rb_Sumar.isChecked==true){
            val suma =  valor1_Int+valor2_Int
            val resultado = suma.toString()
            V_Resultado.setText(resultado)
        }else if (rb_Restar.isChecked==true){
            val resta =  valor1_Int-valor2_Int
            val resultado = resta.toString()
            V_Resultado.setText(resultado)
        }else if(rb_Multiplicar.isChecked==true){
            val Multiplicacion =  valor1_Int*valor2_Int
            val resultado = Multiplicacion.toString()
            V_Resultado.setText(resultado)
        }else if(rb_Dividir.isChecked==true) {
            if(valor1_Int != 0 && valor2_Int != 0){
                val division = valor1_Int/valor2_Int
                val resultado = division.toString()
                V_Resultado.setText(resultado)
            }else{
                Toast.makeText(this,"No puede dividir entre 0 ", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun btn_Siguiente(Vista: View){
        val ventana:Intent = Intent(applicationContext,MainActivity2::class.java)
        startActivity(ventana)

    }


}




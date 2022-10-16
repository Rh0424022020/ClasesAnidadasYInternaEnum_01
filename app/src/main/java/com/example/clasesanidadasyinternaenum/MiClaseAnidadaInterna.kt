//Stephanie Lucia Rodriguez Henriquez
package com.example.clasesanidadasyinternaenum

class MiClaseAnidadaInterna {
    //Clase anina (Nested class), es una clkase que puede contener otra clase dentro de ella.
    private val uno = 1//Variable global

    private fun retornar1():Int{
        return 1
    }
    class miClaseAninada{

        fun suma(n1:Int, n2:Int):Int{
            return n1+n2
        }
    }

    //Clase interna (Inner Class)
    inner class miClaseINterna{
        fun sumarUno(num:Int):Int{
            return num + uno
        }
        fun sumarDos(num:Int):Int{
            return num + uno+retornar1()
        }

    }
}
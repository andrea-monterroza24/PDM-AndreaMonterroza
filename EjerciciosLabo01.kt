package com.example.laboratorio1

import org.junit.Test

class EjerciciosLabo01 {

    //Ejercicio 1

    data class Programa(
        val nombre:  String
    )

    class Computadora(
        var ram: Int,
        var almacenamiento: Int,
        var sistemaOperativo: String,
        var programasInstalados: List<Programa>
    ) {

        fun encenderComputadora() {
            println("La computadora esta encendida")
        }

        fun apagarComputadora() {
            println("La computadora se apago")
        }

        fun actualizarRAM(nuevaRAM: Int) {
            ram = nuevaRAM
            println("RAM actualizada a $ram GB")
        }

        fun actualizarAlmacenamiento(nuevoAlmacenamiento: Int) {
            almacenamiento = nuevoAlmacenamiento
            println("Almacenamiento actualizado a $almacenamiento GB")
        }

        fun cambiarSistemaOperativo(nuevoSO: String) {
            sistemaOperativo = nuevoSO
            println("Sistema operativo cambiado a $sistemaOperativo")
        }

        fun programasDelAnioActual(anioActual: Int): List<Programa> {
            return programasInstalados.filter {
                it.nombre.contains(anioActual.toString())
            }
        }
    }

    @Test
    fun pruebaComputadora() {

        val programas = listOf(
            Programa("Notion 2026"),
            Programa("Facebook 2024"),
            Programa("Spotify 2026"),
            Programa("Instagram 2023")
        )

        val computadora = Computadora(
            ram = 8,
            almacenamiento = 256,
            sistemaOperativo = "Windows 11",
            programasInstalados = programas
        )

        computadora.encenderComputadora()

        computadora.actualizarRAM(16)
        computadora.actualizarAlmacenamiento(512)
        computadora.cambiarSistemaOperativo("Linux")

        val programasActuales = computadora.programasDelAnioActual(2026)

        println("Programas del año actual:")
        programasActuales.forEach {
            println(it.nombre)
        }

        computadora.apagarComputadora()
    }

//Ejercicio 2

    class Calculadora(
        val marca: String,
        val aniosVida: Int,
        var precio: Double
    ) {

        fun sumar(a: Double, b: Double): Double {
            return a + b
        }

        fun restar(a: Double, b: Double): Double {
            return a - b
        }

        fun multiplicar(a: Double, b: Double): Double {
            return a * b
        }

        fun dividir(a: Double, b: Double): Double {

            if (b == 0.0) {
                throw IllegalArgumentException("No se puede dividir entre 0")
            }

            return a / b
        }
    }

    @Test
    fun pruebaCalculadora() {

        val calculadora = Calculadora(
            marca = "Casio",
            aniosVida = 10,
            precio = 25.0
        )

        println("Suma: ${calculadora.sumar(5.0, 3.0)}")
        println("Resta: ${calculadora.restar(10.0, 4.0)}")
        println("Multiplicación: ${calculadora.multiplicar(6.0, 2.0)}")
        println("División: ${calculadora.dividir(8.0, 2.0)}")

    }


    @Test
    fun pruebaDivisionError() {

        val calculadora = Calculadora("Casio", 10, 25.0)

        calculadora.dividir(5.0, 0.0)

    }

    //Ejercicio 3

    data class Estudiante(
        val nombre: String,
        val carnet: Int,
        val asignatura: String
    )

    @Test
    fun estudiantesDispositivosMoviles() {

        val Ciclo01 = listOf(

            Estudiante("Andrea Monterroza", 22001, "PDM"),
            Estudiante("Carlos Pérez", 22002, "PDM"),
            Estudiante("Lucía Gómez", 22003, "PDM"),

            Estudiante("Mario López", 22004, "Análisis Numérico"),
            Estudiante("Ana Torres", 22005, "Análisis Numérico"),
            Estudiante("Pedro Ruiz", 22006, "Análisis Numérico"),
            Estudiante("Sofía Castro", 22007, "Análisis Numérico")
        )

        val dispositivosMoviles = Ciclo01.filter {
            it.asignatura == "PDM"
        }

        println("Estudiantes en Programacion de Dispositivos Moviles:")

        dispositivosMoviles.forEach {
            println("${it.nombre} - ${it.carnet}")
        }
    }
}


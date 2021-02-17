package com.example.miguel.dominio.entities

class Moneda {
    fun volado(): CarasMoneda {
        return CarasMoneda.values().random()
    }

    enum class CarasMoneda(
            val paraHumanos: String
    ) {
        CARA("Cara"),
        CRUZ("Cruz")
    }
}
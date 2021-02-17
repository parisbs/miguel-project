package com.example.miguel.dominio.juegos

import com.example.miguel.dominio.entities.Moneda

class TirarUnVolado : Monedas {
    override fun volado(): Moneda.CarasMoneda = Moneda().volado()
}
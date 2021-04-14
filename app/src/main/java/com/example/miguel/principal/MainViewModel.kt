package com.example.miguel.principal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miguel.casosdeuso.JuegosDisponibles
import com.example.miguel.dominio.entities.Juego
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(
    private val backgroundContext: CoroutineContext,
    private val juegosDisponibles: JuegosDisponibles
) : ViewModel() {

    private val listaDeJuegos = MutableLiveData<ListaDeJuegos>()
    val juegos: LiveData<ListaDeJuegos>
        get() = listaDeJuegos

    init {
        getListaDeJuegos()
    }

    fun getListaDeJuegos() = viewModelScope.launch(backgroundContext) {
        juegosDisponibles().takeIf { it.isEmpty().not() }?.also {
            listaDeJuegos.postValue(ListaDeJuegos.Correcto(it))
        } ?: listaDeJuegos.postValue(ListaDeJuegos.Error)
    }

    sealed class ListaDeJuegos {
        class Correcto(val juegos: List<Juego>): ListaDeJuegos()
        object Error: ListaDeJuegos()
    }
}
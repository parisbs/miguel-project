package com.example.miguel.segundo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miguel.casosdeuso.TirarUnDado
import com.example.miguel.dominio.entities.Dado
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SecondViewModel(
        private val backgroundContext: CoroutineContext,
    private val tirarUnDado: TirarUnDado
) : ViewModel() {

    private val resultadoDeDado = MutableLiveData<ResultadoDados>()
    val tirada: LiveData<ResultadoDados>
        get() = resultadoDeDado

    fun lanzarLosDados(caras: Int) = viewModelScope.launch(backgroundContext) {
        tirarUnDado(caras)?.also {
            resultadoDeDado.postValue(ResultadoDados.Correcto(it))
        } ?: resultadoDeDado.postValue(ResultadoDados.Error)
    }

    sealed class ResultadoDados {
        class Correcto(val valorDeDado: Int) : ResultadoDados()
        object Error : ResultadoDados()
    }
}
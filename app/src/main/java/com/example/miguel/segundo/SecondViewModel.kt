package com.example.miguel.segundo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miguel.casosdeuso.TirarUnDadoDeSeisCaras
import com.example.miguel.dominio.entities.Dado6Caras
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SecondViewModel(
        private val backgroundContext: CoroutineContext,
    private val tirarUnDadoDeSeisCaras: TirarUnDadoDeSeisCaras
) : ViewModel() {

    private val resultadoDeDado = MutableLiveData<ResultadoDados>()
    val tirada: LiveData<ResultadoDados>
        get() = resultadoDeDado

    fun lanzarLosDados() = viewModelScope.launch(backgroundContext) {
        when (val resultado = tirarUnDadoDeSeisCaras()) {
            is Dado6Caras -> resultadoDeDado.postValue(ResultadoDados.Correcto(uresultado.tirarDado()))
            else -> resultadoDeDado.postValue(ResultadoDados.Error)
        }
    }

    sealed class ResultadoDados {
        class Correcto(val valorDeDado: Int) : ResultadoDados()
        object Error : ResultadoDados()
    }
}
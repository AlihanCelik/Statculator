package com.alihan.istatikselhesaplayc.Bernoulli

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class BernouilliViewModel : ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun calculateBernoilli(p: Double, x: Double) {
        try {
            val poissonResult = ( p.pow(x) * (1-p).pow(1-x))
            _result.value = String.format("%.5f", poissonResult)
        } catch (e: Exception) {
            _result.value = "Hata!"
        }
    }

}
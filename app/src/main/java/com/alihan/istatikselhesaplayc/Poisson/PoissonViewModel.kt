package com.alihan.istatikselhesaplayc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.exp
import kotlin.math.pow

class PoissonViewModel : ViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun calculatePoisson(lambda: Double, x: Int) {
        try {
            val poissonResult = (exp(-lambda) * lambda.pow(x)) / factorial(x)
            _result.value = String.format("%.5f", poissonResult)
        } catch (e: Exception) {
            _result.value = "Hata!"
        }
    }

    private fun factorial(n: Int): Double {
        return if (n == 0) 1.0 else (1..n).reduce { acc, i -> acc * i }.toDouble()
    }
}

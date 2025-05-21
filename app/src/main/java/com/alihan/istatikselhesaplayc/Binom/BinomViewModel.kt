package com.alihan.istatikselhesaplayc.Binom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class BinomViewModel :ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun calculateBinom(x: Double, n: Double, p: Double) {
        try {
            val xInt = x.toInt()
            val nInt = n.toInt()

            if (xInt > nInt || p < 0 || p > 1) {
                _result.value = "Geçersiz değerler!"
                return
            }
                val combination = factorial(nInt) / (factorial(xInt) * factorial(nInt - xInt))
                val probability = combination * p.pow(xInt) * (1 - p).pow(nInt - xInt)
            _result.value = String.format("%.5f",probability)

        } catch (e: Exception) {
            _result.value = "Hesaplama hatası!"
        }
    }

    private fun factorial(n: Int): Long {
        return if (n <= 1) 1 else n * factorial(n - 1)
    }
}
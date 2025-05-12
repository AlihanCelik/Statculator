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

            var totalProbability = 0.0
            val details = StringBuilder()

            for (i in 0..xInt) {
                val combination = factorial(nInt) / (factorial(i) * factorial(nInt - i))
                val probability = combination * p.pow(i) * (1 - p).pow(nInt - i)
                totalProbability += probability

                details.append("P(X = $i) = ${"%.5f".format(probability)}\n")
            }

            details.append("Toplam (P(X ≤ $xInt)) = ${"%.5f".format(totalProbability)}")
            _result.value = details.toString()

        } catch (e: Exception) {
            _result.value = "Hesaplama hatası!"
        }
    }

    private fun factorial(n: Int): Long {
        return if (n <= 1) 1 else n * factorial(n - 1)
    }
}
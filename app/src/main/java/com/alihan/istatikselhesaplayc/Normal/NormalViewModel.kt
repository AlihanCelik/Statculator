package com.alihan.istatikselhesaplayc.Normal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class NormalViewModel :ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun calculateNormalDistribution(x: Double, mean: Double, stdDev: Double) {
        try {
            if (stdDev <= 0.0) {
                _result.value = "Standart sapma > 0 olmalı!"
                return
            }

            val exponent = -0.5 * ((x - mean) / stdDev).pow(2)
            val denominator = stdDev * kotlin.math.sqrt(2 * Math.PI)
            val resultValue = (1 / denominator) * kotlin.math.exp(exponent)

            _result.value = String.format("%.5f", resultValue)
        } catch (e: Exception) {
            _result.value = "Hata!"
        }
    }
}
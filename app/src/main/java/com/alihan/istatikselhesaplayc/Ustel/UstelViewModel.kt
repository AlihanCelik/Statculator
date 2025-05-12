package com.alihan.istatikselhesaplayc.Ustel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.exp

class UstelViewModel : ViewModel() {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun calculateustel(lambda: Double, x: Double) {
        try {
            val poissonResult = (lambda * exp(-lambda*x))
            _result.value = String.format("%.5f", poissonResult)
        } catch (e: Exception) {
            _result.value = "Hata!"
        }
    }
}
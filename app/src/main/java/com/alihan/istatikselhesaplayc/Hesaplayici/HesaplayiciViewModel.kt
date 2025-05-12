package com.alihan.istatikselhesaplayc.Hesaplayici

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.ExpressionBuilder

class HesaplayiciViewModel : ViewModel() {

    private val _inputText = MutableLiveData<String>("")
    val inputText: LiveData<String> = _inputText

    private val _resultText = MutableLiveData<String>("")
    val resultText: LiveData<String> = _resultText

    fun appendValue(value: String) {
        _inputText.value += value
    }

    fun clear() {
        _inputText.value = ""
        _resultText.value = ""
    }

    fun backspace() {
        _inputText.value = _inputText.value?.dropLast(1)
    }

    fun calculate() {
        try {
            val expressionStr = _inputText.value?.replace('x', '*')
            val expression = ExpressionBuilder(expressionStr).build()
            val result = expression.evaluate()
            _resultText.value = result.toString()
        } catch (e: Exception) {
            _resultText.value = "HATA"
        }
    }
}

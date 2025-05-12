package com.alihan.istatikselhesaplayc.Duzgun

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alihan.istatikselhesaplayc.databinding.ActivityDuzgunDagilimBinding

class DuzgunDagilimActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDuzgunDagilimBinding
    private val viewModel: DuzgunDagilimViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDuzgunDagilimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geriButton.setOnClickListener{
            finish()
        }

        viewModel.result.observe(this) { result ->
            binding.tvSonuc.text = result
            binding.tvSonuc.visibility = if (result.isEmpty()) View.GONE else View.VISIBLE
        }

        binding.btnHesapla.setOnClickListener {
            val b = binding.etLambda.text.toString()
            val aText = binding.etX.text.toString()

            if (b.isNotEmpty() && aText.isNotEmpty()) {
                val p = b.toDouble()
                val x = aText.toDouble()
                viewModel.calculateBernoilli(p, x)
            }
        }
    }
}
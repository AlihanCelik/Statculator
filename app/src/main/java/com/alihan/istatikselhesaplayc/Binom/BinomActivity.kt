package com.alihan.istatikselhesaplayc.Binom

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alihan.istatikselhesaplayc.databinding.ActivityBinomBinding

class BinomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBinomBinding
    private val viewModel: BinomViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBinomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geriButton.setOnClickListener{
            finish()
        }

        viewModel.result.observe(this) { result ->
            binding.tvSonuc.text = result
            binding.tvSonuc.visibility = if (result.isEmpty()) View.GONE else View.VISIBLE
        }

        binding.btnHesapla.setOnClickListener {
            val n = binding.nText.text.toString()
            val p = binding.pText.text.toString()
            val x= binding.xText.text.toString()

            if (n.isNotEmpty() && p.isNotEmpty() && x.isNotEmpty()) {
                val n = n.toDouble()
                val p = p.toDouble()
                val x = x.toDouble()
                viewModel.calculateBinom(x, n,p)
            }
        }
    }
}
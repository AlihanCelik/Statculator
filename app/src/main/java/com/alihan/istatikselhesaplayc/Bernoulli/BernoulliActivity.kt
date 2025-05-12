package com.alihan.istatikselhesaplayc.Bernoulli

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alihan.istatikselhesaplayc.databinding.ActivityBernoulliBinding

class BernoulliActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBernoulliBinding
    private val viewModel: BernouilliViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBernoulliBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geriButton.setOnClickListener{
            finish()
        }

        viewModel.result.observe(this) { result ->
            binding.tvSonuc.text = result
            binding.tvSonuc.visibility = if (result.isEmpty()) View.GONE else View.VISIBLE
        }

        binding.btnHesapla.setOnClickListener {
            val p = binding.etLambda.text.toString()
            val xText = binding.etX.text.toString()

            if (p.isNotEmpty() && xText.isNotEmpty()) {
                val p = p.toDouble()
                val x = xText.toDouble()
                viewModel.calculateBernoilli(p, x)
            }
        }
    }
}
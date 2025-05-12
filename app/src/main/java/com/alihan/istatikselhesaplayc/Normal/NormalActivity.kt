package com.alihan.istatikselhesaplayc.Normal

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alihan.istatikselhesaplayc.databinding.ActivityNormalBinding

class NormalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNormalBinding
    private val viewModel: NormalViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNormalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geriButton.setOnClickListener{
            finish()
        }

        viewModel.result.observe(this) { result ->
            binding.tvSonuc.text = result
            binding.tvSonuc.visibility = if (result.isEmpty()) View.GONE else View.VISIBLE
        }

        binding.btnHesapla.setOnClickListener {
            val sigma = binding.etLambda.text.toString()
            val mu = binding.etX.text.toString()
            val x= binding.xdegisken.text.toString()

            if (sigma.isNotEmpty() && mu.isNotEmpty() && x.isNotEmpty()) {
                val sigma = sigma.toDouble()
                val mu = mu.toDouble()
                val x = x.toDouble()
                viewModel.calculateNormalDistribution(x, mu,sigma)
            }
        }
    }
}
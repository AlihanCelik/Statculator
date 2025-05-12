package com.alihan.istatikselhesaplayc.Poisson

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alihan.istatikselhesaplayc.PoissonViewModel
import com.alihan.istatikselhesaplayc.databinding.ActivityPoissonBinding

class PoissonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPoissonBinding
    private val poissonViewModel: PoissonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPoissonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geriButton.setOnClickListener{
            finish()
        }

        poissonViewModel.result.observe(this) { result ->
            binding.tvSonuc.text = result
            binding.tvSonuc.visibility = if (result.isEmpty()) View.GONE else View.VISIBLE
        }

        binding.btnHesapla.setOnClickListener {
            val lambdaText = binding.etLambda.text.toString()
            val xText = binding.etX.text.toString()

            if (lambdaText.isNotEmpty() && xText.isNotEmpty()) {
                val lambda = lambdaText.toDouble()
                val x = xText.toInt()
                poissonViewModel.calculatePoisson(lambda, x)
            }
        }
    }
}

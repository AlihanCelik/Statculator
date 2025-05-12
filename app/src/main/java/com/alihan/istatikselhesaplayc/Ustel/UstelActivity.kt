package com.alihan.istatikselhesaplayc.Ustel

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alihan.istatikselhesaplayc.databinding.ActivityUstelBinding

class UstelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUstelBinding
    private val poissonViewModel: UstelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUstelBinding.inflate(layoutInflater)
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
                val x = xText.toDouble()
                poissonViewModel.calculateustel(lambda, x)
            }
        }
    }
}
package com.alihan.istatikselhesaplayc.Hesaplayici

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.alihan.istatikselhesaplayc.databinding.FragmentHesaplayiciBinding

class HesaplayiciFragment : Fragment() {

    private lateinit var binding: FragmentHesaplayiciBinding
    private val viewModel: HesaplayiciViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHesaplayiciBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.inputText.observe(viewLifecycleOwner, Observer {
            binding.input.setText(it)
        })

        viewModel.resultText.observe(viewLifecycleOwner, Observer {
            binding.resultDisplay.setText(it)
        })

        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6,
            binding.btn7, binding.btn8, binding.btn9,
            binding.btnAddition, binding.btnSubtraction,
            binding.btnMultiply, binding.btnDivide,
            binding.btnDot
        )

        numberButtons.forEach { button ->
            button.setOnClickListener {
                viewModel.appendValue(button.text.toString())
            }
        }

        binding.opernParantez.setOnClickListener {
            viewModel.appendValue("(")
        }

        binding.closeBtn.setOnClickListener {
            viewModel.appendValue(")")
        }


            binding.butonAC.setOnClickListener {
            viewModel.clear()
        }

        binding.buttonC.setOnClickListener {
            viewModel.backspace()
        }

        binding.btnEqual.setOnClickListener {
            viewModel.calculate()
        }
    }
}

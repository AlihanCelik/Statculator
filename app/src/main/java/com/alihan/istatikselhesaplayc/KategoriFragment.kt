package com.alihan.istatikselhesaplayc

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alihan.istatikselhesaplayc.Bernoulli.BernoulliActivity
import com.alihan.istatikselhesaplayc.Binom.BinomActivity
import com.alihan.istatikselhesaplayc.Duzgun.DuzgunDagilimActivity
import com.alihan.istatikselhesaplayc.Normal.NormalActivity
import com.alihan.istatikselhesaplayc.Poisson.PoissonActivity
import com.alihan.istatikselhesaplayc.Ustel.UstelActivity
import com.google.android.material.card.MaterialCardView


class KategoriFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kategori, container, false)

        val poissonCard = view.findViewById<MaterialCardView>(R.id.poisson_card)
        poissonCard.setOnClickListener {
            val intent = Intent(requireContext(), PoissonActivity::class.java)
            startActivity(intent)
        }

        val bernnolliCard = view.findViewById<MaterialCardView>(R.id.bernoulli_card)
        bernnolliCard.setOnClickListener {
            val intent = Intent(requireContext(), BernoulliActivity::class.java)
            startActivity(intent)
        }

        val duzguncard = view.findViewById<MaterialCardView>(R.id.duzgun_card)
        duzguncard.setOnClickListener {
            val intent = Intent(requireContext(), DuzgunDagilimActivity::class.java)
            startActivity(intent)
        }

        val ustelcard = view.findViewById<MaterialCardView>(R.id.ustel_card)
        ustelcard.setOnClickListener {
            val intent = Intent(requireContext(), UstelActivity::class.java)
            startActivity(intent)
        }

        val normalCard = view.findViewById<MaterialCardView>(R.id.normal_card)
        normalCard.setOnClickListener {
            val intent = Intent(requireContext(), NormalActivity::class.java)
            startActivity(intent)
        }

        val binomCard = view.findViewById<MaterialCardView>(R.id.binom_card)
        binomCard.setOnClickListener {
            val intent = Intent(requireContext(), BinomActivity::class.java)
            startActivity(intent)
        }


        return view
    }



}
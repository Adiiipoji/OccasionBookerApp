package com.example.g

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.g.databinding.FragmentHomeBinding


class FragmentHome : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.cdBirthday.setOnClickListener {
            val intent = Intent(requireContext(), BirthdayActivity::class.java)
            startActivity(intent)
        }

            binding.cdWedding.setOnClickListener {
                val intent = Intent(requireContext(), WeddingActivity::class.java)
                startActivity(intent)
        }

        binding.cdChristening.setOnClickListener {
            val intent = Intent(requireContext(), ChristActivity::class.java)
            startActivity(intent)
        }

        binding.cdThanksgiving.setOnClickListener {
            val intent = Intent(requireContext(), ThanksActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


}
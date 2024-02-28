package com.example.g

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.g.databinding.ActivityBookingLayoutBinding
import com.example.g.databinding.FragmentProfileBinding
import com.example.oop.BookingLayoutActivity


class FragmentProfile : Fragment() {

    private lateinit var binding: FragmentProfileBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.textView4.setOnClickListener{
            val intent = Intent(requireContext(), BookingLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.textView5.setOnClickListener{
            val intent = Intent(requireContext(), AboutAppProfile::class.java)
            startActivity(intent)
        }

        binding.textView6.setOnClickListener{
            val intent = Intent(requireContext(), TermsandConditionsProfile::class.java)
            startActivity(intent)
        }

        binding.textView7.setOnClickListener{
            val intent = Intent(requireContext(), PrivacyPolicyProfile::class.java)
            startActivity(intent)
        }



        return binding.root
    }


}
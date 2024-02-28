package com.example.g

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.g.databinding.ActivityBirthdayBinding
import com.example.g.databinding.ActivityBookingLayoutBinding
import com.example.g.databinding.FragmentBookingBinding
import com.example.oop.BookingLayoutActivity
import com.google.android.material.textfield.TextInputEditText

class FragmentBooking : Fragment() {

    private lateinit var name: EditText
    private lateinit var event: EditText
    private lateinit var contact: EditText
    private lateinit var place: EditText
    private lateinit var date: EditText
    private lateinit var time: EditText
    private lateinit var db: DBHelper


    private lateinit var binding: FragmentBookingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBookingBinding.inflate(inflater, container, false)


        name = binding.editTextText5
        event = binding.editTextText6
        contact = binding.editTextNumber
        place = binding.editTextText7
        date = binding.editTextDate
        time = binding.editTextTime




        binding.button2.setOnClickListener{
            val intent = Intent(requireContext(), BookingLayoutActivity::class.java)
            startActivity(intent)

            val name = name.text.toString()
            val event = event.text.toString()
            val contact = contact.text.toString()
            val place = place.text.toString()
            val date = date.text.toString()
            val time = time.text.toString()
            val savedata =db.saveuserdata(event,name,contact,place,date,time)

            if(TextUtils.isEmpty(event) || TextUtils.isEmpty(name) || TextUtils.isEmpty(contact) || TextUtils.isEmpty(place) || TextUtils.isEmpty(date) || TextUtils.isEmpty(time)){
                Toast.makeText(requireContext(), "Fill up the blanks", Toast.LENGTH_SHORT).show()
            }
            else{
                if (savedata==true){
                    Toast.makeText(requireContext(), "Fill up the blanks", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(requireContext(), "Fill up the blanks", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root




    }

}
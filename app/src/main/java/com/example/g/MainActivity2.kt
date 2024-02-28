package com.example.g

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.g.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var database: MyDatas


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewsss.setOnClickListener{
            val intent = Intent(this, MainActivity3:: class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {

            val useredtx = binding.editTextText.text.toString()
            val passedtx = binding.editTextText2.text.toString()
            database = MyDatas(this)

            if (TextUtils.isEmpty(useredtx) || TextUtils.isEmpty(passedtx)) {
                Toast.makeText(this, "Fill up the blanks", Toast.LENGTH_SHORT).show()
            } else {
                val checking = database.checkuserpass(useredtx, passedtx)
                if (checking == true) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "You successfully Log in", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, "Incorrect Detailed", Toast.LENGTH_SHORT).show()
                }
            }


        }


    }
}
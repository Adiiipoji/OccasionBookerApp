package com.example.g

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.g.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    private lateinit var database: MyDatas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogin.setOnClickListener {
            val intent = Intent (this, MainActivity2:: class.java)

            startActivity(intent)
        }

        binding.button.setOnClickListener {

            val name = binding.editTextText.text.toString()
            val pass = binding.editTextText2.text.toString()
            val compass = binding.editTextText3.text.toString()
            database = MyDatas(this)
            val saveuser = database.insertdata(name, pass)



            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(compass)) {
                Toast.makeText(this, "Add Username or Password", Toast.LENGTH_SHORT).show()
            } else {
                if (pass == compass) {
                    if (saveuser == true) {
                        Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent (this, MainActivity2:: class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "User Exists", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show()
                }
            }



        }
        

    }
}
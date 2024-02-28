package com.example.g

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.g.databinding.ActivityThanksBinding

class ThanksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThanksBinding
    private lateinit var newArrayList:ArrayList<Trendings>
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var image: Array<Int>
    private lateinit var name: Array<String>
    private lateinit var price: Array<String>
    private lateinit var theme: Array<String>
    private lateinit var sample: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThanksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        image = arrayOf(
            R.drawable.thanksth,
            R.drawable.thankscat,
            R.drawable.thanksinv,
        )

        name = arrayOf(
            "Simple Thanksgiving",
            "Filipino Food",
            "For Relatives",
        )

        price = arrayOf(
            "Engrande Thanksgiving",
            "Foreigners Food",
            "For Friends",
        )

        theme = arrayOf(
            "Theme",
            "Catering",
            "Invitation",
        )

        sample = arrayOf(
            "Sample Theme:",
            "Sample Catering:",
            "Sample Invitation:",
        )

        newRecyclerView = binding.recyclerView
        newRecyclerView.layoutManager = GridLayoutManager(this, 1)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUser()




    }

    private fun getUser(){
        for (i in image.indices){
            val data  = Trendings(image[i], name[i], price [i], theme[i], sample[i])
            newArrayList.add(data)
        }
        newRecyclerView.adapter = TrendingsAdapter(newArrayList)

    }


}
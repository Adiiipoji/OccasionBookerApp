package com.example.oop

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.g.DBHelper
import com.example.g.Datalist
import com.example.g.MainActivity4
import com.example.g.MyAdapter2
import com.example.g.R

class BookingLayoutActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var dbh: DBHelper
    private lateinit var newArry: ArrayList<Datalist>
    private lateinit var adapter: MyAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_layout)

        recyclerView = findViewById(R.id.recyclerView)

        dbh = DBHelper(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        displayuser()
    }

    private fun displayuser(){
        val newcursor: Cursor? = dbh!!.gettext()
        newArry = ArrayList<Datalist>()
        while (newcursor!!.moveToNext()){
            val uevent = newcursor.getString(0)
            val uname = newcursor.getString(1)
            val ucontact = newcursor.getString(2)
            val uplace = newcursor.getString(3)
            val udate = newcursor.getString(4)
            val utime = newcursor.getString(5)

            newArry.add(Datalist(uevent, uname, ucontact, uplace, udate, utime))
        }
        adapter = MyAdapter2(newArry)

        recyclerView.adapter = adapter
        adapter.onItemClickListener(object : MyAdapter2.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@BookingLayoutActivity, MainActivity4 ::class.java)
                intent.putExtra("event", newArry[position].event)
                intent.putExtra("name", newArry[position].name)
                intent.putExtra("contact", newArry[position].contact)
                intent.putExtra("place", newArry[position].place)
                intent.putExtra("date", newArry[position].date)
                intent.putExtra("time", newArry[position].time)
                startActivity(intent)
            }

        })


    }
}
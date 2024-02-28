package com.example.g

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter2 (var userList: ArrayList<Datalist>): RecyclerView.Adapter<MyAdapter2.MyViewHolder>() {


    private lateinit var mListener:onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun onItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        val tevent:  TextView = itemView.findViewById(R.id.textView)
        val tname: TextView = itemView.findViewById(R.id.textView2)
        val tcontact: TextView = itemView.findViewById(R.id.textView3)
        val tplace: TextView = itemView.findViewById(R.id.textView4)
        val tdate: TextView = itemView.findViewById(R.id.textView5)
        val ttime: TextView = itemView.findViewById(R.id.textView6)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.tevent.text= currentItem.event
        holder.tname.text= currentItem.name
        holder.tcontact.text = currentItem.contact
        holder.tplace.text= currentItem.place
        holder.tdate.text= currentItem.date
        holder.ttime.text = currentItem.time
    }

}
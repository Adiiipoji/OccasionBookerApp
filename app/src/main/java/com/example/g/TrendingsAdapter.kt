package com.example.g

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrendingsAdapter(private val productList: List<Trendings>): RecyclerView.Adapter<TrendingsAdapter.TrendingsViewHolder>() {

    class TrendingsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val myImage : ImageView = itemView.findViewById(R.id.myImage)
        val tvName : TextView = itemView.findViewById(R.id.tvName)
        val tvPrice : TextView = itemView.findViewById(R.id.tvPrice)
        val tvTheme : TextView = itemView.findViewById(R.id.tvTheme)
        val tvSample : TextView = itemView.findViewById(R.id.tvSample)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return TrendingsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: TrendingsViewHolder, position: Int) {
        val products =  productList[position]
        holder.myImage.setImageResource(products.productImages)
        holder.tvName.text = products.productName
        holder.tvPrice.text = products.productPrice
        holder.tvTheme.text = products.productTheme
        holder.tvSample.text = products.productSample
    }



}
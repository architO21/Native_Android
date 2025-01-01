package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response

class MyAdapter2(
    var context: Context,
    var itemList: List<ApiDataItem>
) : RecyclerView.Adapter<MyAdapter2.MyViewHolder>() {

    // ViewHolder class to hold the views
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.name1)
        val itemPrice: TextView = itemView.findViewById(R.id.price1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(context).inflate(R.layout.listitem2, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Bind the data to the views
        val item = itemList[position]
        holder.itemName.text = item.name
        holder.itemPrice.text = "₹${item.price}"
    }

    override fun getItemCount(): Int {
        // Return the size of the data list
        return itemList.size
    }
}

package com.example.myapplication
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var con:Context,
                var list:List<ApiDataItem>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
inner class ViewHolder(v: View):RecyclerView.ViewHolder(v)
{
   val itemName:TextView=v.findViewById(R.id.itemName)
    val itemMRP:TextView=v.findViewById(R.id.itemMRP)
    val shippingInfo:TextView=v.findViewById(R.id.shippingInfo)

}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(con).inflate(R.layout.listitem, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.itemName.text = item.name
        holder.itemMRP.text = "MRP: ₹${item.price}"
        holder.shippingInfo.text = item.extra
    }
    override fun getItemCount(): Int {
        return list.size
    }
}
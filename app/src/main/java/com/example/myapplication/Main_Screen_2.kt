package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Main_Screen_2 : AppCompatActivity() {
    private val activity=this
    lateinit var rvMain1:RecyclerView
    lateinit var myAdapter1: MyAdapter2
    var BASE_URL="https://mocki.io/v1/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getAllData()
     rvMain1=findViewById(R.id.listlays)
        rvMain1.layoutManager=GridLayoutManager(this,3)

        val circles = listOf<View>(
            findViewById(R.id.circle0),
            findViewById(R.id.circle1),
            findViewById(R.id.circle2),
            findViewById(R.id.circle3),
            findViewById(R.id.circle4)
        )
        highlightCircle(1,circles)
        circles.forEachIndexed { index, circle ->
            circle.setOnClickListener {
                highlightCircle(index, circles)
                displayselected(index)
            }
        }
    }

    private fun highlightCircle(selectedIndex: Int, circles: List<View>) {
        circles.forEachIndexed { index, view ->
            if (index == selectedIndex) {
                view.setBackgroundResource(R.drawable.circle_selected)
            } else {
                view.setBackgroundResource(R.drawable.circle_unselected)
            }
        }
    }
    private fun displayselected(selectedIndex: Int)
    {
        if(selectedIndex==0)
        {
            startActivity(Intent(activity,MainActivity::class.java))
        }
    }
    private fun getAllData() {
        var retrofit=
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(Apidata::class.java)
        var retroData=retrofit.getData()
        retroData.enqueue(object: Callback<List<ApiDataItem>> {
            override fun onResponse(
                call: Call<List<ApiDataItem>>,
                response: Response<List<ApiDataItem>>
            ) {
                if(response.isSuccessful)
                {
                    val dat="yes"
                    val data = response.body()?: emptyList()
                    print("data fetched successfully")

                    myAdapter1 = MyAdapter2(baseContext,data)
                    rvMain1.adapter = myAdapter1
                    print(data.toString())
                    Log.d("data", data.toString())
                }
                else
                {

                    print("data not fetched")
                }
            }

            override fun onFailure(call: Call<List<ApiDataItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}

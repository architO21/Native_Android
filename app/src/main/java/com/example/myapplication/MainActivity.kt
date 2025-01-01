package com.example.myapplication


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
   private val activity=this
    lateinit var rvMain:RecyclerView
    lateinit var myAdapter: MyAdapter
    var BASE_URL="https://mocki.io/v1/"
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        startActivity(Intent(activity,TopAppbar::class.java))
        rvMain=findViewById(R.id.rvMain)
        rvMain.layoutManager=LinearLayoutManager(this)
        getAllData()

            val circles = listOf<View>(
                findViewById(R.id.circle0),
                findViewById(R.id.circle1),
                findViewById(R.id.circle2),
                findViewById(R.id.circle3),
                findViewById(R.id.circle4)
            )

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
        if(selectedIndex!=0)
        {
            startActivity(Intent(activity,Main_Screen_2::class.java))
        }
    }



    private fun getAllData() {
        var retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(Apidata::class.java)
        var retroData=retrofit.getData()
        retroData.enqueue(object:Callback<List<ApiDataItem>>{
            override fun onResponse(
                call: Call<List<ApiDataItem>>,
                response: Response<List<ApiDataItem>>
            ) {
                if(response.isSuccessful)
                {
                    val dat="yes"
                    val data = response.body()?: emptyList()
                    print("data fetched successfully")

                    myAdapter = MyAdapter(baseContext, data)
                    rvMain.adapter = myAdapter
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
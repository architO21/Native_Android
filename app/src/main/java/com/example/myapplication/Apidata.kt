package com.example.myapplication


import retrofit2.Call
import retrofit2.http.GET

interface Apidata
{

    @GET("e8342d5c-9ff8-49e8-978e-a7cec3a65c08")
 fun getData():Call<List<ApiDataItem>>
}
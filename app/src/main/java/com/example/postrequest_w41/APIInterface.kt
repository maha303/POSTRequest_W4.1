package com.example.postrequest_w41

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {
    @GET("/test/")
    fun doGetListResources(): Call<List<UserDetails.Dutum>>
    @POST("/test/")
    fun addUser(@Body userData:UserDetails.Dutum):Call<UserDetails.Dutum>

}
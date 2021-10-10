package com.example.postrequest_w41

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var mytValue :TextView
    private lateinit var btnAdd:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mytValue=findViewById(R.id.tvValue)

        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        apiInterface?.doGetListResources()?.enqueue(object :Callback<List<UserDetails.Dutum>>{
            override fun onResponse(call: Call<List<UserDetails.Dutum>>,response: Response<List<UserDetails.Dutum>>){
                Log.d("TAG",response.code().toString()+"")
                var displayResponse=""
                for (datum in response.body()!!){
                    displayResponse = displayResponse +datum.name+ "\n"+datum.location + "\n"+"\n"
                }
                mytValue.text=displayResponse
            }
            override fun onFailure(call: Call<List<UserDetails.Dutum>>, t: Throwable) {
                Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show();
            }
        })

        btnAdd=findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener{
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
}
    }
}
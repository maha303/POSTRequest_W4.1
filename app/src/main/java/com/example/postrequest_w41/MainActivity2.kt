package com.example.postrequest_w41

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {

    private lateinit var edName:EditText
    private lateinit var edLocations :EditText
    private lateinit var btnSave:Button
    private lateinit var btnView :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        edName=findViewById(R.id.edName)
        edLocations=findViewById(R.id.edLocations)
        btnSave=findViewById(R.id.btnSave)
        btnSave.setOnClickListener{
            var f= UserDetails.Dutum(edName.text.toString(),edLocations.text.toString())
            addUsers(f, onResult = {
                edName.setText("")
                edLocations.setText("")
                Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show();
            })
        }
        btnView=findViewById(R.id.btnView)
        btnView.setOnClickListener{
            val int = Intent(this,MainActivity::class.java)
            startActivity(int)
        }
    }
    private fun addUsers(f:UserDetails.Dutum,onResult: ()->Unit){
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        apiInterface?.addUser(f)?.enqueue(object :Callback<UserDetails.Dutum>{
            override fun onResponse(call: Call<UserDetails.Dutum>, response: Response<UserDetails.Dutum>) {
                onResult()
            }

            override fun onFailure(call: Call<UserDetails.Dutum>, t: Throwable) {
                onResult()
                Toast.makeText(this@MainActivity2,"Not Saved &&",Toast.LENGTH_LONG).show()
            }
        })
    }
}


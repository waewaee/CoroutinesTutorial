package com.waewaee.coroutinestutorial.ui

import android.util.Log
import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivityMainBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : BaseActivity<ActivityMainBinding>(inflate = ActivityMainBinding::inflate) {

    val TAG = "MainActivity"

    override fun initUi() {
        setContentView(R.layout.activity_main)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getComments()
            if (response.isSuccessful) {
                for (comment in response.body()!!) {
                    Log.d(TAG, comment.toString())
                }
            }
        }

//        api.getComments().enqueue(object : Callback<List<Comment>> {
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        for (comment in it) {
//                            Log.d(TAG, comment.toString())
//                        }
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                Log.e(TAG, "Error: $t")
//            }
//
//        })

    }

    override fun observe() {

    }

}
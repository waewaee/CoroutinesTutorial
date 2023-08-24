package com.waewaee.coroutinestutorial.ui

import android.telecom.Call
import retrofit2.http.GET

interface MyAPI {

    @GET("/comments")
    suspend fun getComments(): Call<List<Comment>>
}
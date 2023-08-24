package com.waewaee.coroutinestutorial.ui

import android.util.Log
import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivityMainBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : BaseActivity<ActivityMainBinding>(inflate = ActivityMainBinding::inflate) {

    val TAG = "MainActivity"

    override fun initUi() {
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val answer1 = async { doNetworkCall1() }
                val answer2 = async { doNetworkCall2() }
                Log.d(TAG, "Answer1 is ${answer1.await()}")
                Log.d(TAG, "Answer2 is ${answer2.await()}")
            }
            Log.d(TAG, "Request took  $time ms")
        }
    }

    suspend fun doNetworkCall1() : String {
        delay(3000L)
        return "Answer 1"
    }

    suspend fun doNetworkCall2() : String {
        delay(3000L)
        return "Answer 2"
    }

    override fun observe() {

    }

}
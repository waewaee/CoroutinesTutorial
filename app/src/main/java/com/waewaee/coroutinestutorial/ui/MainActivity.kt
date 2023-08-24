package com.waewaee.coroutinestutorial.ui

import android.util.Log
import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivityMainBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : BaseActivity<ActivityMainBinding>(inflate = ActivityMainBinding::inflate) {

    val TAG = "MainActivity"

    override fun initUi() {
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                var answer1: String? = null
                var answer2: String? = null
                var job1 = launch { answer1 = doNetworkCall1() }
                var job2 = launch { answer2 = doNetworkCall2() }
                job1.join()
                job2.join()
                Log.d(TAG, "Answer1 is $answer1")
                Log.d(TAG, "Answer2 is $answer2")
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
package com.waewaee.coroutinestutorial.ui

import android.util.Log
import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivityMainBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : BaseActivity<ActivityMainBinding>(inflate = ActivityMainBinding::inflate) {

    val TAG = "MainActivity"

    override fun initUi() {
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Starting long running calculation.....")
            for(i in 30..40) {
                Log.d(TAG, "Result for i = $i : ${fib(i)}")
            }
            Log.d(TAG, "Ending long running calculation.....")
        }
        runBlocking {
            delay(2000L)
            job.cancel()
            Log.d(TAG, "Cancelled job!")
        }

    }

    fun fib(n: Int) : Long {
        return if(n == 0) 0
        else if(n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }

    override fun observe() {

    }

}
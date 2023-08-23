package com.waewaee.coroutinestutorial.ui

import android.util.Log
import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivityMainBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class MainActivity : BaseActivity<ActivityMainBinding>(inflate = ActivityMainBinding::inflate) {

    val TAG = "MainActivity"

    override fun initUi() {
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Starting long running calculation.....")
            withTimeout(3000L) {
                for(i in 30..40) {
                    if (isActive) {
                        Log.d(TAG, "Result for i = $i : ${fib(i)}")
                    }
                }
                Log.d(TAG, "Ending long running calculation.....")
            }
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
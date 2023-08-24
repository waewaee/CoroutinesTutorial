package com.waewaee.coroutinestutorial.ui

import android.content.Intent
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivityMainBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>(inflate = ActivityMainBinding::inflate) {

    val TAG = "MainActivity"

    override fun initUi() {
        setContentView(R.layout.activity_main)

        binding.btnStartActivity.setOnClickListener {
            lifecycleScope.launch {
                while (true) {
                    delay(1000L)
                    Log.d(TAG, "Still running.....")
                }
            }

            GlobalScope.launch {
                delay(5000L)
                Intent(this@MainActivity, SecondActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    override fun observe() {

    }

}
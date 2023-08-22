package com.waewaee.coroutinestutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.waewaee.coroutinestutorial.databinding.ActivitySampleBinding
import com.waewaee.coroutinestutorial.databinding.ActivitySampleBinding.inflate
import com.waewaee.coroutinestutorial.ui.base.BaseActivity
import com.waewaee.coroutinestutorial.ui.theme.CoroutinesTutorialTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : BaseActivity<ActivitySampleBinding>(inflate = ActivitySampleBinding::inflate) {

    val TAG = "MainActivity"

    override fun initUi() {
        setContentView(R.layout.activity_sample)

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "Starting coroutine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main) {
                Log.d(TAG, "Setting text in thread ${Thread.currentThread().name}")
                binding.tvDummy.text = answer
            }
        }
    }

    override fun observe() {

    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }
}
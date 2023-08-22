package com.waewaee.coroutinestutorial.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waewaee.coroutinestutorial.R

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
    }
}
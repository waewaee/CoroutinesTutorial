package com.waewaee.coroutinestutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivitySecondBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity

class SecondActivity : BaseActivity<ActivitySecondBinding>(inflate = ActivitySecondBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun initUi() {

    }

    override fun observe() {

    }

}
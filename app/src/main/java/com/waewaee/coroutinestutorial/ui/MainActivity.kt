package com.waewaee.coroutinestutorial.ui

import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivityMainBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(inflate = ActivityMainBinding::inflate) {

    override fun initUi() {
        setContentView(R.layout.activity_main)

    }

    override fun observe() {

    }

}
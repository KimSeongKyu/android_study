package com.web_view.viewpagerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val views = listOf(customViewA(this), customViewB(this), customViewC(this), customViewD(this))
        val adapter = CustomPageAdapter()
        adapter.views = views

        viewPager.adapter = adapter
    }
}
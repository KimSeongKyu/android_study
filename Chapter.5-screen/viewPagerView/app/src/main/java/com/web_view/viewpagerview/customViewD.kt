package com.web_view.viewpagerview

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout

class customViewD(context: Context?) : LinearLayout(context) {
    init{
        val view = LayoutInflater.from(context).inflate(R.layout.layout_d, this, false)
        addView(view)
    }
}
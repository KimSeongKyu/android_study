package com.web_view.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    var total = 0
    var isStarted = false

    val handler = object: Handler(){
        override fun handleMessage(msg: Message) {
            val minute = String.format("%02d", total/60)
            val second = String.format("%02d", total%60)
            textTimer.text = "$minute:$second"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            isStarted = true
            thread(start=true){
                while(isStarted){
                    Thread.sleep(1000)
                    if(isStarted){
                        total += 1
                        handler?.sendEmptyMessage(0)
                    }
                }
            }
        }

        buttonStop.setOnClickListener {
            if(isStarted){
                isStarted = false
                total = 0
                textTimer.text = "00:00"
            }
        }
    }
}
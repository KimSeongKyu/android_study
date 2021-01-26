package com.web_view.networkhttpurlconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonRequest.setOnClickListener {
            thread(start = true){
                try {
                    var urlText = editUrl.text.toString()
                    if (!urlText.startsWith("https")) urlText = "https://$urlText"
                    val url = URL(urlText)
                    val urlConnection = url.openConnection() as HttpURLConnection
                    urlConnection.requestMethod = "GET"
                    if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                        val streamReader = InputStreamReader(urlConnection.inputStream)
                        val buffer = BufferedReader(streamReader)

                        val content = StringBuilder()
                        while (true) {
                            val line = buffer.readLine() ?: break
                            content.append(line)
                        }
                        buffer.close()
                        urlConnection.disconnect()

                        runOnUiThread {
                            textContent.text = content.toString()
                        }
                    }
                } catch(e: Exception){
                    e.printStackTrace()
                }
            }
        }
    }
}
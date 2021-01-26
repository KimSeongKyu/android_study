package com.web_view.contentresolver

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermission()
    }

    fun checkPermission(){
        val permission = ContextCompat.checkSelfPermission(this, permissions[0])
        if(permission == PackageManager.PERMISSION_GRANTED) startProcess()
        else requestPermission()
    }

    fun startProcess(){
        setContentView(R.layout.activity_main)

        val adapter = MusicRecyclerAdapter()
        adapter.musicList.addAll(getMusicList())

        recyclerVieew.adapter = adapter
        recyclerVieew.layoutManager = LinearLayoutManager(this)

    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 99)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            99 -> {
                var check = true
                for(grant in grantResults){
                    if(grant != PackageManager.PERMISSION_GRANTED){
                        check = false
                        break
                    }
                }
                if(check) startProcess()
                else {
                    Toast.makeText(this, "권한 요청을 모두 승인해야 앱을 실행할 수 있습니다.", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }

    fun getMusicList(): List<Music> {
        val listUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val proj = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.DURATION
            )

        val cursor = contentResolver.query(listUri, proj, null, null, null)
        val musicList = mutableListOf<Music>()

        while(cursor?.moveToNext() == true){
            val id = cursor.getString(0)
            val title = cursor.getString(1)
            val artist = cursor.getString(2)
            val albumId = cursor.getString(3)
            val duration = cursor.getLong(4)

            val music = Music(id, title, artist, albumId, duration)
            musicList.add(music)
        }

        return musicList
    }
}
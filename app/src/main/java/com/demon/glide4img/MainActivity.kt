package com.demon.glide4img

import android.content.Intent
import android.media.MediaMetadataRetriever
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1.setOnClickListener {
            startActivity(Intent(this, UseBaseActivity::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(this, UseAdvancedActivity::class.java))
        }

        btn3.setOnClickListener {
            startActivity(Intent(this, TransformActivity::class.java))
        }

        btn4.setOnClickListener {
            startActivity(Intent(this, VideoCoverActivity::class.java))
        }

        btn5.setOnClickListener {

        }

        btn6.setOnClickListener {
            startActivity(Intent(this, LongImgActivity::class.java))
        }
    }
}

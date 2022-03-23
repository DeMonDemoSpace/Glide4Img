package com.demon.glide4img

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val requestMultiplePermissions = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){

    }

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
            startActivity(Intent(this, CacheActivity::class.java))
        }

        btn6.setOnClickListener {
            startActivity(Intent(this, LongImgActivity::class.java))
        }


        requestMultiplePermissions.launch(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE))
    }
}

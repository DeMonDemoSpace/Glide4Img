package com.demon.glide4img

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}

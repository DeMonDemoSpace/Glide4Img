package com.demon.glide4img

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_use_base.*


class UseBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_base)

        Glide.with(this).load(ConstUrl.ImgLogo).into(ivLogo)

        val options = RequestOptions()
            .placeholder(R.mipmap.loading)
            .error(R.mipmap.error)
        Glide.with(this).load(ConstUrl.ImgOne).apply(options).into(ivUrl)

        Glide.with(this)
            .asBitmap()
            .load(ConstUrl.ImgGif)
            .into(ivGiftFirst)

        Glide.with(this)
            .load(ConstUrl.ImgGif)
            .into(ivGift)
    }
}

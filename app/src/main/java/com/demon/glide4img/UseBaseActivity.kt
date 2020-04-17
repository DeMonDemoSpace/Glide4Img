package com.demon.glide4img

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_use_base.*
import java.io.File


class UseBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_base)
        val url = "http://guolin.tech/book.png"
        val options = RequestOptions()
            .placeholder(R.mipmap.loading)
            .error(R.mipmap.error)
            .skipMemoryCache(true)
            //.override(100, 200)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
        Glide.with(this).load(url).apply(options).into(ivUrl)


        Glide.with(this)
            .asBitmap()
            .load("http://guolin.tech/test.gif")
            .into(ivGiftFirst)

        Glide.with(this)
            .load("http://guolin.tech/test.gif")
            .listener(object :RequestListener<Drawable>{
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    TODO("Not yet implemented")
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    TODO("Not yet implemented")
                }
            })
            .into(ivGift)
    }
}

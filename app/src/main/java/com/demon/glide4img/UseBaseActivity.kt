package com.demon.glide4img

import android.app.ProgressDialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.*
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.activity_use_base.*
import java.io.File


class UseBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_base)

        Glide.with(this).load(ConstUrl.ImgLogo).into(ivLogo)

        val options = RequestOptions()
            .placeholder(R.mipmap.loading)
            .error(R.mipmap.error)
            .skipMemoryCache(true)
            //.override(100, 200)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
        Glide.with(this).load(ConstUrl.ImgOne).apply(options).into(ivUrl)


        val dialog = ProgressDialog(this)
        val simpleTarget = object : DrawableImageViewTarget(ivInto) {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                super.onResourceReady(resource, transition)
                dialog.dismiss()
            }

            override fun onLoadStarted(placeholder: Drawable?) {
                super.onLoadStarted(placeholder)
                dialog.show()
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                super.onLoadFailed(errorDrawable)
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                super.onLoadCleared(placeholder)
            }

            override fun onStart() {
                super.onStart()
            }

            override fun onStop() {
                super.onStop()
            }

            override fun onDestroy() {
                super.onDestroy()
            }
        }

        val optionInto = RequestOptions()
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionInto).into(simpleTarget)


        Glide.with(this)
            .asBitmap()
            .load(ConstUrl.ImgGif)
            .into(ivGiftFirst)

        Glide.with(this)
            .load(ConstUrl.ImgGif)
            .into(ivGift)
    }
}

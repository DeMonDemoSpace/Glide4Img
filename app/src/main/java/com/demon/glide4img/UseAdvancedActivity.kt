package com.demon.glide4img

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.activity_use_advanced.*

class UseAdvancedActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_advanced)

        Glide.with(this)
            .load(ConstUrl.ImgGif)
            .preload()

        preload.setOnClickListener {
            Glide.with(this)
                .load(ConstUrl.ImgGif)
                .into(ivPreload)
        }


        /*Glide.with(this).load(ConstUrl.ImgOne).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                Log.e(TAG, "onLoadFailed", e)
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                Log.i(TAG, "onResourceReady")
                return false
            }
        }).into(ivListener)*/

        download.setOnClickListener {
            Thread(Runnable {
                val taget = Glide.with(this).asFile().load(ConstUrl.ImgOne).submit()
                val imgFile = taget.get()
                runOnUiThread {
                    Glide.with(this).load(imgFile).into(ivDownload)
                    Toast.makeText(this, imgFile.path, Toast.LENGTH_LONG).show()
                }
            }).start()
        }


        val simpleTarget = object : DrawableImageViewTarget(ivInto) {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                super.onResourceReady(resource, transition)
                Log.i(TAG, "onResourceReady: ")
                progressBar.hide()
            }

            override fun onLoadStarted(placeholder: Drawable?) {
                super.onLoadStarted(placeholder)
                Log.i(TAG, "onLoadStarted: ")
                progressBar.show()

            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                super.onLoadFailed(errorDrawable)
                Log.i(TAG, "onLoadFailed: ")
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                super.onLoadCleared(placeholder)
                Log.i(TAG, "onLoadCleared: ")
            }
        }
        val optionInto = RequestOptions()
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
        Glide.with(this).load(ConstUrl.ImgGif).apply(optionInto).into(simpleTarget)



        Glide.with(this).load(ConstUrl.ImgOne).apply(optionInto).into(MyTarget(targetLayout))
    }
}

package com.demon.glide4img

import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.HandlerThread
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.signature.ObjectKey
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_cache.*

class CacheActivity : AppCompatActivity() {
    private val TAG = "CacheActivity"

    private var sp: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache)
        sp = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE)
        initImg()
        refresh.setOnClickListener {
            sp?.let {
                it.edit().putLong("glide_key", System.currentTimeMillis()).apply()
            }
            initImg()
        }

        delMemory.setOnClickListener {
            runOnUiThread {
                //必须在主线程上调用
                Glide.get(this).clearMemory()
            }
        }


        delMemory.setOnClickListener {
            Thread {
                //此方法应始终在后台线程上调用，因为它是阻塞调用
                Glide.get(this).clearDiskCache()
            }.start()
        }
    }


    private fun initImg() {
        val key = sp?.getLong("glide_key", 0L) ?: 0L
        val optionInto = RequestOptions()
            .transform(CircleCrop(), BlurTransformation())
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .signature(ObjectKey(key))
        Glide.with(this)
            .load(ConstUrl.ImgOne)
            .apply(optionInto)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    Log.i(TAG, "onLoadFailed: ")
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    Log.i(TAG, "onResourceReady: $dataSource")
                    return false
                }
            })
            .into(iv)
    }
}
package com.demon.glide4img

import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import jp.wasabeef.glide.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.activity_long_img.*

class LongImgActivity : AppCompatActivity() {
    private val long_img = "https://idemon.oss-cn-guangzhou.aliyuncs.com/long1.jpeg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_long_img)


        val option1 = RequestOptions()
            .transform(RoundedCornersTransformation(5.intDp, 0))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.default_image)
            .placeholder(R.drawable.default_image)
            .dontAnimate()
            .fitCenter()

        Glide.with(this)
            .asBitmap()
            .load(long_img)
            .thumbnail(0.5f)
            .apply(option1)
            .into(iv_image)

        val option2 = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.default_image)
            .placeholder(R.drawable.default_image)
            .dontAnimate()
            .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)

        Glide.with(this)
            .load(long_img)
            .apply(option2)
            .into(iv_pic)
    }
}

val Int.intDp
    get() = this.toFloat().dp.toInt()

val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )
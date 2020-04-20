package com.demon.glide4img

import android.content.Context
import android.graphics.*
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import jp.wasabeef.glide.transformations.BitmapTransformation
import jp.wasabeef.glide.transformations.internal.Utils
import java.security.MessageDigest

/**
 * @author DeMon
 * Created on 2020/4/20.
 * E-mail 757454343@qq.com
 * Desc:
 */
class HeaddressTransformation constructor(private val maskId: Int) : BitmapTransformation() {

    private val VERSION = 1
    private val ID = "com.demon.glide4img.HeaddressTransformation.$VERSION"

    private val sMaskingPaint by lazy {
        Paint().apply {
            xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
        }
    }

    override fun hashCode(): Int {
        return ID.hashCode() + maskId * 10
    }

    override fun equals(other: Any?): Boolean {
        return other is HeaddressTransformation &&
                other.maskId == maskId
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update((ID + maskId).toByteArray(Key.CHARSET))
    }

    override fun transform(context: Context, pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap {

        val width = toTransform.width
        val height = toTransform.height
        val result: Bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888)

        Canvas(result).run {
            val mask = Utils.getMaskDrawable(context.applicationContext, maskId)
            mask.setBounds(0, 0, width, height)
            mask.draw(this)
            drawBitmap(toTransform, 0f, 0f, sMaskingPaint)
        }
        return result
    }
}
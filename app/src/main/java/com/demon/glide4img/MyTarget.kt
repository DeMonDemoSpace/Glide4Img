package com.demon.glide4img

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition

/**
 * @author DeMon
 * Created on 2020/4/20.
 * E-mail 757454343@qq.com
 * Desc:
 */
class MyTarget constructor(view: View) : CustomViewTarget<View, Drawable>(view) {
    override fun onLoadFailed(errorDrawable: Drawable?) {

    }

    override fun onResourceCleared(placeholder: Drawable?) {

    }

    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
        view.findViewById<ImageView>(R.id.iv1).setImageDrawable(resource)
    }

}
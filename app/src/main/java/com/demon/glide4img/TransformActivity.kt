package com.demon.glide4img

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import jp.wasabeef.glide.transformations.*
import jp.wasabeef.glide.transformations.gpu.*
import kotlinx.android.synthetic.main.activity_transform.*


class TransformActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transform)

        val optionsScaleType = RequestOptions().override(Target.SIZE_ORIGINAL)
        Glide.with(this).load(ConstUrl.ImgUrl).apply(optionsScaleType).into(ivScaleType)

        //圆形转换
        val optionsCircle = RequestOptions().circleCrop()
        Glide.with(this).load(ConstUrl.ImgUrl).apply(optionsCircle).into(ivCircle)

        //高斯模糊
        val optionsBlur = RequestOptions().transform(BlurTransformation())
        Glide.with(this).load(ConstUrl.ImgUrl).apply(optionsBlur).into(ivBlur)

        //圆角矩形
        val optionsRounded = RequestOptions().transform(RoundedCornersTransformation(30, 0))
        Glide.with(this).load(ConstUrl.ImgUrl).apply(optionsRounded).into(ivRounded)

        //灰度转换
        val optionsGray = RequestOptions().transform(GrayscaleTransformation())
        Glide.with(this).load(ConstUrl.ImgUrl).apply(optionsGray).into(ivGray)

        //裁剪转换
        val optionsCrop = RequestOptions().transform(CropTransformation(500, 200, CropTransformation.CropType.TOP))
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsCrop).into(ivCrop)
        //正方形裁剪
        val optionsSquare = RequestOptions().transform(CropSquareTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsSquare).into(ivSquare)

        //图形变换
        val optionsMask = RequestOptions().transform(MaskTransformation(R.drawable.mask_starfish))
        Glide.with(this).load(ConstUrl.ImgUrl).apply(optionsMask).into(ivMask)

        val optionsMask1 = RequestOptions().transform(MaskTransformation(R.drawable.x))
        Glide.with(this).load(ConstUrl.ImgUrl).apply(optionsMask1).into(ivMask1)


        //高亮效果
        val optionsBrightness = RequestOptions().transform(BrightnessFilterTransformation(0.3f))
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsBrightness).into(ivBrightness)

        //滤镜效果
        val optionsContrast = RequestOptions().transform(ContrastFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsContrast).into(ivContrast)

        //虚幻效果
        val optionsInvert = RequestOptions().transform(InvertFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsInvert).into(ivInvert)

        //马赛克效果
        val optionsKuwahara = RequestOptions().transform(KuwaharaFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsKuwahara).into(ivKuwahara)

        //像素效果
        val optionsPixelation = RequestOptions().transform(PixelationFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsPixelation).into(ivPixelation)

        //漫画效果
        val optionsSepia = RequestOptions().transform(SepiaFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsSepia).into(ivSepia)

        //铅笔画效果
        val optionsSketch = RequestOptions().transform(SketchFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsSketch).into(ivSketch)

        //漩涡效果
        val optionsSwirl = RequestOptions().transform(SwirlFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsSwirl).into(ivSwirl)

        //油画效果
        val optionsToon = RequestOptions().transform(ToonFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsToon).into(ivToon)

        //暗边效果
        val optionsVignette = RequestOptions().transform(VignetteFilterTransformation())
        Glide.with(this).load(ConstUrl.ImgOne).apply(optionsVignette).into(ivVignette)


        //圆形头饰效果
        val optionsHeaddress = RequestOptions().centerInside().transforms(CropCircleTransformation(), HeaddressTransformation(R.drawable.pic_kehu_hg))
        Glide.with(this).load(ConstUrl.ImgUrl).apply(optionsHeaddress).into(ivHead)

    }
}

package com.demon.glide4img

import android.media.MediaMetadataRetriever
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_video_cover.*

class VideoCoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_cover)

        val options = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .frame(1000000)
            .placeholder(R.drawable.pic_zwt)
            .centerCrop()
        Glide.with(this)
            .setDefaultRequestOptions(options)
            .load("http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4")
            .into(image1)

        val retriever = MediaMetadataRetriever()
        retriever.setDataSource("http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4", HashMap())
        //获得第10帧图片 这里的第一个参数 以微秒为单位
        val bitmap = retriever.getFrameAtTime(10000000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
        retriever.release()
        image2.setImageBitmap(bitmap)
    }
}
package com.demon.glide4img

import android.app.Application
import android.os.Environment
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache

/**
 * @author DeMon
 * Created on 2022/3/23.
 * E-mail idemon_liu@qq.com
 * Desc:
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val builder: GlideBuilder = GlideBuilder()
        //设置内存缓存大小为20mb
        val memoryCacheSize = 1024 * 1024 * 20 // 20mb
        //设置内存缓存大小
        builder.setMemoryCache(LruResourceCache(memoryCacheSize.toLong()))
        //设置硬盘缓存大小为200mb
        val diskCacheSize = 1024 * 1024 * 200 // 200mb
        //根据SD卡是否可用选择是在内部缓存还是SD卡缓存
        //Glide_images标识缓存的目录名
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            builder.setDiskCache(ExternalPreferredCacheDiskCacheFactory(this, "Glide_images", diskCacheSize.toLong()))
        } else {
            builder.setDiskCache(InternalCacheDiskCacheFactory(this, "Glide_images", diskCacheSize.toLong()))
        }
        Glide.init(this, builder)
    }
}
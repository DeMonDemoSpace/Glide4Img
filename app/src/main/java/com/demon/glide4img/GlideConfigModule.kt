package com.demon.glide4img

import android.content.Context
import android.os.Environment
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule

/**
 * @author DeMon
 * Created on 2022/3/23.
 * E-mail idemon_liu@qq.com
 * Desc:
 */
@GlideModule
class GlideConfigModule : AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean = false

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        //registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory())
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        //设置内存缓存大小为20mb
        val memoryCacheSize = 1024 * 1024 * 20 // 20mb
        //设置内存缓存大小
        builder.setMemoryCache(LruResourceCache(memoryCacheSize.toLong()))
        //设置硬盘缓存大小为200mb
        val diskCacheSize = 1024 * 1024 * 200 // 200mb
        //根据SD卡是否可用选择是在内部缓存还是SD卡缓存
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            builder.setDiskCache(ExternalPreferredCacheDiskCacheFactory(context, "Glide_images", diskCacheSize.toLong()))
        } else {
            builder.setDiskCache(InternalCacheDiskCacheFactory(context, "Glide_images", diskCacheSize.toLong()))
        }

    }
}
package com.example.waterfallrecycler;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {
	private LruCache<String, Bitmap> mImageCache;
	
	private static BitmapCache sBitmapCache;
	
	public static BitmapCache getInstance() {
		if (null == sBitmapCache) {
			sBitmapCache = new BitmapCache();
		}
		return sBitmapCache;
	}
	

	public BitmapCache() {
		// 获取应用程序最大可用内存
		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		int cacheSize = maxMemory / 8;
		// 设置图片缓存大小为程序最大可用内存的1/8
		mImageCache = new LruCache<String, Bitmap>(cacheSize) {
			@Override
			protected int sizeOf(String key, Bitmap bitmap) {
				return bitmap.getRowBytes() * bitmap.getHeight();
			}
		};
	}

	@Override
	public Bitmap getBitmap(String url) {
		return mImageCache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		mImageCache.put(url, bitmap);
	}

}

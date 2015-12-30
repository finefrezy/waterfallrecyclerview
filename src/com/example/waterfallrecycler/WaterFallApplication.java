package com.example.waterfallrecycler;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class WaterFallApplication extends Application {

	
	private static RequestQueue sRequestQueue;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		sRequestQueue = Volley.newRequestQueue(getApplicationContext());
	}

	
	public static RequestQueue getReqQueue() {
		return sRequestQueue;
	}
}

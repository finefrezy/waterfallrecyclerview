package com.example.waterfallrecycler;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;

public class DeliciousFoodAdapter extends RecyclerView.Adapter<DeliciousFoodVH> {

	private List<DeliciousFoodModel> mDeliciousFoodList;
	private ImageLoader mImageLoader;
	private Context mContext;

	public DeliciousFoodAdapter(Context ctx, List<DeliciousFoodModel> deliciousFoodList) {
		mDeliciousFoodList = deliciousFoodList;
		mContext = ctx;
		mImageLoader = new ImageLoader(WaterFallApplication.getReqQueue(),
				BitmapCache.getInstance());
	}

	@Override
	public int getItemCount() {
		if (null == mDeliciousFoodList) {
			return 0;
		}
		return mDeliciousFoodList.size();
	}

	/**
	 * 为控件填充内容
	 */
	@Override
	public void onBindViewHolder(DeliciousFoodVH viewHolder, int position) {

		viewHolder.mContext = mContext;
		viewHolder.mPosition = position;

		ImageListener listener = ImageLoader.getImageListener(
				viewHolder.mUrlImage, R.drawable.ic_launcher,
				R.drawable.ic_launcher);
		mImageLoader.get(mDeliciousFoodList.get(position).foodImg, listener);

		viewHolder.mNameText.setText(mDeliciousFoodList.get(position).foodName);
		viewHolder.mDescTest.setText(mDeliciousFoodList.get(position).foodDesc);
		viewHolder.mPraiseImage.setTag(position + "");

	}

	@Override
	public DeliciousFoodVH onCreateViewHolder(ViewGroup parent, int position) {
		// View view = LayoutInflater.from(parent.getContext()).inflate(
		// R.layout.water_fall_item, parent, false);

		Log.d("DeliciousFoodVH", "onCreateViewHolder = " + position);
		View view = View.inflate(parent.getContext(), R.layout.water_fall_item,
				null);
		return new DeliciousFoodVH(view);
	}

}

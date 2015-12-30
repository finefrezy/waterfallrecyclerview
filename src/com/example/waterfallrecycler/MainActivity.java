package com.example.waterfallrecycler;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class MainActivity extends Activity {
	RecyclerView mRecyclerView;
	// 集合数据填充recyclerview
	private List<DeliciousFoodModel> mDeliciousFoodList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRecyclerView = (RecyclerView) findViewById(R.id.forum_list);
		// 设置layoutManager
		// 2代表列数， StaggeredGridLayoutManager.VERTICAL代表垂直分布
		mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
				StaggeredGridLayoutManager.VERTICAL));
		// 设置adapter
		initData();

		DeliciousFoodAdapter adapter = new DeliciousFoodAdapter(this,
				mDeliciousFoodList);
		mRecyclerView.setAdapter(adapter);
		// 设置item之间的间隔， 6代表间隔大小
		SpacesItemDecoration decoration = new SpacesItemDecoration(6);
		mRecyclerView.addItemDecoration(decoration);
	}

	private void initData() {
		mDeliciousFoodList = new ArrayList<DeliciousFoodModel>();
		for (int i = 0; i < 20; i++) {
			DeliciousFoodModel delicious = new DeliciousFoodModel();
			delicious.foodName = "螺蛳粉" + i;
			delicious.foodDesc = "螺蛳粉是广西柳州特产！";
			if (i % 5 == 0) {
				delicious.foodImg = "http://img4.duitang.com/uploads/blog/201307/03/20130703212525_JBtjC.jpeg";
			} else if (i % 5 == 1) {
				delicious.foodImg = "http://img3.imgtn.bdimg.com/it/u=3576404707,510258566&fm=21&gp=0.jpg";
			} else if (i % 5 == 2) {
				delicious.foodImg = "http://pic7.nipic.com/20100527/5036928_102815000890_2.jpg";
			} else if (i % 5 == 3) {
				delicious.foodImg = "http://img5.duitang.com/uploads/item/201307/30/20130730150022_R42zK.jpeg";
			} else {
				delicious.foodImg = "http://img2.imgtn.bdimg.com/it/u=1743488240,888748410&fm=21&gp=0.jpg";
			}
			mDeliciousFoodList.add(delicious);
		}
	}

}

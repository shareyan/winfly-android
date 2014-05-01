package com.example.testfragment;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Point size = new Point();
		Display display = getWindowManager().getDefaultDisplay();
		display.getSize(size);
		if(size.x > size.y){
			Fragment1 fragment1 = new Fragment1();
			getFragmentManager().beginTransaction().replace(R.id.main_layout,fragment1).commit();
		}else{
			Fragment2 fragment2 = new Fragment2();
			getFragmentManager().beginTransaction().replace(R.id.main_layout,fragment2).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

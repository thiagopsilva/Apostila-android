package org.example.ari;

import org.example.ari.R.color;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

@SuppressLint({ "ResourceAsColor", "NewApi" })
public class Ari extends Activity implements OnClickListener{
	LinearLayout arilayout;
	Button btcolor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ari);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		btcolor = (Button) findViewById(R.id.button2);
		arilayout = (LinearLayout) findViewById(R.id.arilayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ari, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.button1:
			Log.d("DEBUGER", "Color 1");
			arilayout.setBackgroundColor(color.background2);
			break;
		case R.id.button2:
			Log.d("DEBUGER", "Color 2");
			btcolor.setBackgroundColor(Color.GREEN);
			btcolor.setTextColor(Color.WHITE);
			break;
		}
	}
}

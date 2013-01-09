package org.example.browserintent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class BrowserIntent extends Activity {
	private EditText urlText;
	private Button goButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser_intent);
		//Get a handle to all user interface elements
		urlText = (EditText) findViewById(R.id.url_field);
		goButton = (Button) findViewById(R.id.go_button);
		// Setup event handlers
		goButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				openBrowser();
			}
		});
	
	urlText.setOnEditorActionListener(new OnEditorActionListener() {
		public boolean 	onEditorAction(TextView v, int actionId,
				KeyEvent event) {
			if (actionId == EditorInfo.IME_NULL) {
				openBrowser();
				InputMethodManager imm = (InputMethodManager)
						getSystemService(INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				return false;
			}
			return false;
		}
	});}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_browser_intent, menu);
		return true;
	}

	/** Open a browser on the URL specified in the text box */
	private void openBrowser() {
		Uri uri = Uri.parse(urlText.getText().toString());
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}

}

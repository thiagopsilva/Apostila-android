package org.example.browserview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class BrowserView extends Activity {
	private EditText urlText;
	private WebView webView;
	private Button goButton;
	// ...

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browser_view);
		webView = (WebView) findViewById(R.id.web_view);
		urlText = (EditText) findViewById(R.id.url_field);
		goButton = (Button) findViewById(R.id.go_button);
		// Setup event handlers
		goButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				openBrowser();
			}
		});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_browser_view, menu);
		return true;
	}
	
	private void openBrowser() {
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(urlText.getText().toString());
	}
}

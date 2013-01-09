package org.example.localbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LocalBrowser extends Activity {
	private static final String TAG = "LocalBrowser";
	private final Handler handler = new Handler();
	private WebView webView;
	private TextView textView;
	private Button button;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local_browser);
		
		// Find the Android controls on the screen
		webView = (WebView) findViewById(R.id.web_view);
		textView = (TextView) findViewById(R.id.text_view);
		button = (Button) findViewById(R.id.button);
		
		// Turn on JavaScript in the embedded browser
		webView.getSettings().setJavaScriptEnabled(true);
		
		// Expose a Java object to JavaScript in the browser
		webView.addJavascriptInterface(new AndroidBridge(),"android");
		
		// Set up a function to be called when JavaScript tries
		// to open an alert window
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public boolean onJsAlert(final WebView view, final String url, final String message, JsResult result) {
				Log.d(TAG, "onJsAlert(" + view + ", " + url + ", " + message + ", " + result + ")");
				Toast.makeText(LocalBrowser.this, message, 3000).show();
				result.confirm();
				return true; // I handled it
			}
		});
	}

	/** Object exposed to JavaScript */
	private class AndroidBridge {
		public void callAndroid(final String arg) { // must be final
			handler.post(new Runnable() {
				public void run() {
					Log.d(TAG, "callAndroid(" + arg + ")");
					textView.setText(arg);
				}
			});
		}
	}

}


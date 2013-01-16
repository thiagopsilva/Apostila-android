package com.example.backgroundanimation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

    ViewFlipper viewFlipper;
    static final int ANIMATION_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewFlipper = (ViewFlipper) findViewById(R.id.switcher);
        
        final Handler h = new Handler();
        final Runnable r = new Runnable() {
            
            @Override
            public void run() {
                h.postDelayed(this, ANIMATION_TIME);
                if(viewFlipper.getCurrentView() == viewFlipper.getRootView())
                    viewFlipper.showNext();
                else
                    viewFlipper.showPrevious();
                
                
            }
        };
        h.postDelayed(r, ANIMATION_TIME);
    }
}

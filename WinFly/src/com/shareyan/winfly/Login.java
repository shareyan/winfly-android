package com.shareyan.winfly;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class Login extends Activity {
	private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //textView.setText(getString(R.string.icon_credit_card));
        textView.setTypeface(Typeface.createFromAsset(this.getAssets(), "fontawesome-webfont.ttf"));
//        
//        Typeface font = Typeface.createFromAsset(getAssets(), "");
//        textView.setTypeface(font);
        
        /*TextPaint tp = textView.getPaint();
        tp.setFakeBoldText(true);
        float[] direction = new float[]{ 1, 1, 1 };
        float light = 0.4f;
        float specular = 6;
        float blur = 3.5f;
        EmbossMaskFilter maskfilter=new EmbossMaskFilter(direction,light,specular,blur);
        tp.setMaskFilter(maskfilter);*/
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
}

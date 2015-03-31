package com.saskon.saskon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


public class Anasayfa extends Activity {

    private static final long GET_DATA_INTERVAL = 4000;
    int images[] = {R.drawable.anasayfa_bg1,R.drawable.anasayfa_bg2,R.drawable.anasayfa_bg3,R.drawable.anasayfa_bg4,R.drawable.anasayfa_bg5};
    int index = 0;
    ImageView img;
    Handler hand = new Handler();
    Animation g1Anim;
    Animation g2Anim;
    ViewFlipper mViewFlipper;
    Button startButton;
    private Button buttonClick;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);
        g1Anim = AnimationUtils.loadAnimation(this, R.anim.animation2);
        g2Anim = AnimationUtils.loadAnimation(this, R.anim.animation1);
        mViewFlipper = (ViewFlipper) this.findViewById(R.id.details);
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(5000);
        mViewFlipper.setOutAnimation(g1Anim);
        mViewFlipper.setInAnimation(g2Anim);
        mViewFlipper.startFlipping();
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    startButton.setBackgroundColor(Color.TRANSPARENT);
                    intent = new Intent(Anasayfa.this, MenuListActivity.class);
                    startActivity(intent);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    startButton.setBackgroundResource(R.drawable.siparis_button);
                }
                return false;
            }
        });
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            mViewFlipper.setOutAnimation(g1Anim);
            mViewFlipper.setInAnimation(g2Anim);
            mViewFlipper.startFlipping();
            hand.postDelayed(run, GET_DATA_INTERVAL);
            mViewFlipper.stopFlipping();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_anasayfa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

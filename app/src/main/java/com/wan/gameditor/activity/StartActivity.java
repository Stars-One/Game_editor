package com.wan.gameditor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.wan.gameditor.R;

public class StartActivity extends Activity {

    private LinearLayout mStartlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();

        Animation animation_fade_in= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        final Animation animation_fade_out= AnimationUtils.loadAnimation(this,R.anim.fade_out);

        animation_fade_in.setDuration(2000);
        animation_fade_out.setDuration(2000);

        animation_fade_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mStartlayout.startAnimation(animation_fade_out);
                animation_fade_out.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent();
                        intent.setClass(StartActivity.this, MainActivity.class);
                        finish();
                        StartActivity.this.startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
            mStartlayout.startAnimation(animation_fade_in);
    }

    private void initView() {
        mStartlayout = (LinearLayout) findViewById(R.id.startlayout);

    }
}

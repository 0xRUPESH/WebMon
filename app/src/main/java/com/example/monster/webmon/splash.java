package com.example.monster.webmon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ImageView myImage = (ImageView)findViewById(R.id.splashImg);
        final Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotator);


        AnimationSet animset = new AnimationSet(false);
        animset.addAnimation(rotation);

        final LinearLayout rel = (LinearLayout) findViewById(R.id.main);
        final Animation myfade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotator);
        rel.startAnimation(myfade);

        myfade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(getApplicationContext(),register.class); startActivity(intent); finish();

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }
}

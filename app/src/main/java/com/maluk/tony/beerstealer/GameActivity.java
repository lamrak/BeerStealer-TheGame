package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class GameActivity extends StartActivity {

    ImageButton ibtnCupLU;
    ImageButton ibtnCupLD;
    ImageButton ibtnCupRU;
    ImageButton ibtnCupRD;
    TextView tvWin;
    TextView tvLose;
    TextView tvTextReady;
    ImageView ivArrowLU;
    ImageView ivArrowLD;
    ImageView ivArrowRU;
    ImageView ivArrowRD;
    ImageView ivArrowStealBtn;
    int countWin;
    int countLose;
    int flagLU;
    int flagLD;
    int flagRU;
    int flagRD;
    int damageLU;
    int damageLD;
    int damageRU;
    int damageRD;
    int steal;
    Button stButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-1516709562330550~1549644423");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ibtnCupLU = (ImageButton)findViewById(R.id.cup_left_up);
        ibtnCupLD = (ImageButton)findViewById(R.id.cup_left_down);
        ibtnCupRU = (ImageButton)findViewById(R.id.cup_right_up);
        ibtnCupRD = (ImageButton)findViewById(R.id.cup_right_down);
        tvWin = (TextView)findViewById(R.id.score_win);
        tvLose = (TextView)findViewById(R.id.score_lose);
        tvTextReady = (TextView)findViewById(R.id.steal_text);
        ivArrowLU = (ImageView)findViewById(R.id.arrow_left_up);
        ivArrowLD = (ImageView)findViewById(R.id.arrow_left_down);
        ivArrowRU = (ImageView)findViewById(R.id.arrow_right_up);
        ivArrowRD = (ImageView)findViewById(R.id.arrow_right_down);
        ivArrowStealBtn = (ImageView)findViewById(R.id.arrow_steal_button);
        stButton = (Button) findViewById(R.id.button);

        final Animation animationLU = AnimationUtils.loadAnimation(this, R.anim.transfer_left_up);
        final Animation animationLD = AnimationUtils.loadAnimation(this, R.anim.transfer_left_down);
        final Animation animationRU = AnimationUtils.loadAnimation(this, R.anim.transfer_right_up);
        final Animation animationRD = AnimationUtils.loadAnimation(this, R.anim.transfer_right_down);
        final Animation animationArrow = AnimationUtils.loadAnimation(this, R.anim.animation_arrow);

        ivArrowLU.startAnimation(animationArrow);
        ivArrowLD.startAnimation(animationArrow);
        ivArrowRU.startAnimation(animationArrow);
        ivArrowRD.startAnimation(animationArrow);
        ivArrowStealBtn.startAnimation(animationArrow);

        animationArrow.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                    ivArrowLU.setVisibility(View.INVISIBLE);
                    ivArrowLD.setVisibility(View.INVISIBLE);
                    ivArrowRU.setVisibility(View.INVISIBLE);
                    ivArrowRD.setVisibility(View.INVISIBLE);
                    ivArrowStealBtn.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ibtnCupLU.startAnimation(animationLU);
        ibtnCupLD.startAnimation(animationLD);
        ibtnCupRU.startAnimation(animationRU);
        ibtnCupRD.startAnimation(animationRD);
    }

    public void onMyButtonClick(View view) {

        final Animation animationLU = AnimationUtils.loadAnimation(this, R.anim.transfer_left_up);
        final Animation animationLD = AnimationUtils.loadAnimation(this, R.anim.transfer_left_down);
        final Animation animationRU = AnimationUtils.loadAnimation(this, R.anim.transfer_right_up);
        final Animation animationRD = AnimationUtils.loadAnimation(this, R.anim.transfer_right_down);
        final Animation animLL = AnimationUtils.loadAnimation(this,R.anim.anim_lose_left);
        final Animation animLR = AnimationUtils.loadAnimation(this,R.anim.anim_lose_right);
        final Animation animLLD = AnimationUtils.loadAnimation(this,R.anim.anim_lose_left_down);
        final Animation animLRD = AnimationUtils.loadAnimation(this,R.anim.anim_lose_right_down);

        animationLU.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(flagLU % 3 == 0){
                    ibtnCupLU.setImageResource(R.drawable.ic_cup_dark);
                    damageLU = DAMAGE_POSITIVE;
                }
                if(flagLU % 3 == 1){
                    ibtnCupLU.setImageResource(R.drawable.ic_cup_light);
                    damageLU = DAMAGE_NEGATIVE;
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ibtnCupLU.startAnimation(animLL);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animLL.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(flagLU % 3 == 0){
                    ibtnCupLU.setImageResource(R.drawable.ic_cup_light);
                    flagLU++;
                }
                else countLose++;
                tvLose.setText(getString(R.string.Lost)+":"+countLose);
                ibtnCupLU.startAnimation(animationLU);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animationLD.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(flagLD % 2 == 0){
                    ibtnCupLD.setImageResource(R.drawable.ic_cup_dark);
                    damageLD = DAMAGE_POSITIVE;
                }
                if(flagLD % 2 == 1){
                    ibtnCupLD.setImageResource(R.drawable.ic_cup_light);
                    damageLD = DAMAGE_NEGATIVE;
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ibtnCupLD.startAnimation(animLLD);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animLLD.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(flagLD % 2 == 0){
                    ibtnCupLD.setImageResource(R.drawable.ic_cup_light);
                    flagLD++;
                }
                else countLose++;
                tvLose.setText(getString(R.string.Lost)+":"+countLose);
                ibtnCupLD.startAnimation(animationLD);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animationRU.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(flagRU % 4 == 0){
                    ibtnCupRU.setImageResource(R.drawable.ic_cup_dark);
                    damageRU = DAMAGE_POSITIVE;
                }
                if(flagRU % 4 == 1){
                    ibtnCupRU.setImageResource(R.drawable.ic_cup_light);
                    damageRU = DAMAGE_NEGATIVE;
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ibtnCupRU.startAnimation(animLR);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animLR.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(flagRU % 4 == 0){
                    ibtnCupRU.setImageResource(R.drawable.ic_cup_light);
                    flagRU++;
                }
                else countLose++;
                tvLose.setText(getString(R.string.Lost)+":"+countLose);
                ibtnCupRU.startAnimation(animationRU);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animationRD.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(flagRD % 3 == 0){
                    ibtnCupRD.setImageResource(R.drawable.ic_cup_dark);
                    damageRD = DAMAGE_POSITIVE;
                }
                if(flagRD % 3 == 1){
                    ibtnCupRD.setImageResource(R.drawable.ic_cup_light);
                    damageRD = DAMAGE_NEGATIVE;
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ibtnCupRD.startAnimation(animLRD);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animLRD.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(flagRD % 3 == 0){
                    ibtnCupRD.setImageResource(R.drawable.ic_cup_light);
                    flagRD++;
                }
                else countLose++;
                tvLose.setText(getString(R.string.Lost)+":"+countLose);
                ibtnCupRD.startAnimation(animationRD);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        if(countWin>=10){
            animationLU.setDuration(1500);
            animationLU.setStartOffset(100);
            animLL.setDuration(1000);
            animLL.setStartOffset(500);
            animationLD.setDuration(1500);
            animationLD.setStartOffset(500);
            animLLD.setDuration(1000);
            animLLD.setStartOffset(500);
            animationRU.setDuration(1500);
            animationRU.setStartOffset(750);
            animLR.setDuration(1000);
            animLR.setStartOffset(500);
            animationRD.setDuration(1000);
            animationRD.setStartOffset(600);
            animLRD.setDuration(1000);
            animLRD.setStartOffset(500);
        }
        if(countWin>=20){
            animationLU.setDuration(1000);
            animationLU.setStartOffset(100);
            animLL.setDuration(500);
            animLL.setStartOffset(300);
            animationLD.setDuration(1000);
            animationLD.setStartOffset(300);
            animLLD.setDuration(500);
            animLLD.setStartOffset(300);
            animationRU.setDuration(1000);
            animationRU.setStartOffset(400);
            animLR.setDuration(500);
            animLR.setStartOffset(800);
            animationRD.setDuration(800);
            animationRD.setStartOffset(500);
            animLRD.setDuration(500);
            animLRD.setStartOffset(300);
        }
        if(countWin>=30){
            animationLU.setDuration(1000);
            animationLU.setStartOffset(0);
            animLL.setDuration(500);
            animLL.setStartOffset(100);
            animationLD.setDuration(800);
            animationLD.setStartOffset(0);
            animLLD.setDuration(500);
            animLLD.setStartOffset(100);
            animationRU.setDuration(1200);
            animationRU.setStartOffset(0);
            animLR.setDuration(500);
            animLR.setStartOffset(100);
            animationRD.setDuration(900);
            animationRD.setStartOffset(0);
            animLRD.setDuration(500);
            animLRD.setStartOffset(100);
        }
        if(countWin>=50){
            animationLU.setDuration(500);
            animationLU.setStartOffset(0);
            animLL.setDuration(100);
            animLL.setStartOffset(0);
            animationLD.setDuration(800);
            animationLD.setStartOffset(0);
            animLLD.setDuration(100);
            animLLD.setStartOffset(0);
            animationRU.setDuration(500);
            animationRU.setStartOffset(0);
            animLR.setDuration(100);
            animLR.setStartOffset(0);
            animationRD.setDuration(300);
            animationRD.setStartOffset(0);
            animLRD.setDuration(100);
            animLRD.setStartOffset(0);
        }
        switch (view.getId()) {
            case R.id.cup_left_up:
                countWin++;
                tvWin.setText(getString(R.string.Stolen) + ":" + countWin);
                ibtnCupLU.startAnimation(animationLU);
                steal = 0;
                flagLU++;
                tvTextReady.setText("");
                if(damageLU == DAMAGE_POSITIVE){
                    Intent intent=new Intent(this,EndActivity.class);
                    intent.putExtra("resultscore", tvWin.getText().toString());
                    startActivity(intent);finish();
                }
                break;
            case R.id.cup_left_down:
                countWin++;
                tvWin.setText(getString(R.string.Stolen) + ":" + countWin);
                ibtnCupLD.startAnimation(animationLD);
                steal = 0;
                tvTextReady.setText("");
                flagLD++;
                if(damageLD == DAMAGE_POSITIVE){
                    Intent intent=new Intent(this,EndActivity.class);
                    intent.putExtra("resultscore", tvWin.getText().toString());
                    startActivity(intent);finish();
                }
                break;
            case R.id.cup_right_up:
                countWin++;
                tvWin.setText(getString(R.string.Stolen) + ":" + countWin);
                ibtnCupRU.startAnimation(animationRU);
                steal = 0;
                tvTextReady.setText("");
                flagRU++;
                if(damageRU == DAMAGE_POSITIVE){
                    Intent intent=new Intent(this,EndActivity.class);
                    intent.putExtra("resultscore", tvWin.getText().toString());
                    startActivity(intent);finish();
                }
                break;
            case R.id.cup_right_down:
                countWin++;
                tvWin.setText(getString(R.string.Stolen) + ":" + countWin);
                ibtnCupRD.startAnimation(animationRD);
                steal = 0;
                tvTextReady.setText("");
                flagRD++;
                if(damageRD == DAMAGE_POSITIVE){
                    Intent intent=new Intent(this,EndActivity.class);
                    intent.putExtra("resultscore", tvWin.getText().toString());
                    startActivity(intent);finish();
                }
                break;
            case R.id.button:
                steal = 1;
                tvTextReady.setText(getString(R.string.Ready_to_steal));
                if (this.countLose>=5){
                    Intent intent = new Intent(this,EndActivity.class);
                    intent.putExtra("resultscore", tvWin.getText().toString());
                    startActivity(intent);finish();
                }
                break;
        }
        if (steal == 1) {
            ibtnCupLU.setEnabled(true);
            ibtnCupLD.setEnabled(true);
            ibtnCupRU.setEnabled(true);
            ibtnCupRD.setEnabled(true);
        }
        if (steal == 0) {
            ibtnCupLU.setEnabled(false);
            ibtnCupLD.setEnabled(false);
            ibtnCupRU.setEnabled(false);
            ibtnCupRD.setEnabled(false);
        }
    }
}

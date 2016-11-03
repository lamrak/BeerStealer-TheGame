package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Tony on 19.08.2016.
 */
public class StartActivity extends AppCompatActivity {
    Button btnGame;
    Button btnRules;
    Button btnExit;
    View decorView;
    final int DAMAGE_POSITIVE = 1;
    final int DAMAGE_NEGATIVE = 0;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        decorView = getWindow().getDecorView();

        btnGame =(Button)findViewById(R.id.button_game);
        btnRules =(Button)findViewById(R.id.button_rules);
        btnExit =(Button)findViewById(R.id.button_exit);
    }

    public void omMyStartButtonClick(View view){
        switch(view.getId()){
            case R.id.button_game:
                startActivity(new Intent(this,VoteActivity.class));
                break;
            case R.id.button_rules:
                startActivity(new Intent(this,RulesActivity.class));
                finish();
                break;
            case R.id.button_exit:
                finish();
                break;
        }
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), R.string.Double_click_to_exit,
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}

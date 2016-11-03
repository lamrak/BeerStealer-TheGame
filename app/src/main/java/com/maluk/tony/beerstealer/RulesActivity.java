package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tony on 29.08.2016.
 */
public class RulesActivity extends StartActivity implements View.OnClickListener{

    @BindView(R.id.text_on_top) TextView tvOnTop;
    @BindView(R.id.text_under_pic_steal_button) TextView tvStealBtn;
    @BindView(R.id.text_under_pic_ready_to_steal) TextView tvRedyToSteal;
    @BindView(R.id.text_do_not_steal) TextView tvDoNotSteal;
    @BindView(R.id.text_under_pic_cup) TextView tvCup;
    @BindView(R.id.pic_steal_button) ImageView ivStealBtn;
    @BindView(R.id.pic_ready_to_steal) ImageView ivSteal;
    @BindView(R.id.pic_cup) ImageView ivCup;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        button = (Button)findViewById(R.id.back_button);
        button.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.back_button:
                startActivity(new Intent(this,StartActivity.class));finish();break;
        }
    }
}
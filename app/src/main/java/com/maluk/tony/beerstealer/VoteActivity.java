package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tony on 09.09.2016.
 */
public class VoteActivity extends StartActivity {
    Button btnGameOne;
    Button btnGameTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        btnGameOne = (Button)findViewById(R.id.button_game_one);
        btnGameTwo = (Button)findViewById(R.id.button_game_two);
    }

    public void onVoteClick(View view){
        switch (view.getId()){
            case R.id.button_game_one:
                startActivity(new Intent(this, GameActivity.class));finish();break;
            case R.id.button_game_two:
                startActivity(new Intent(this, GameTwoActivity.class));finish();break;
        }
    }
}

package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.startad.lib.SADView;

/**
 * Created by Tony on 09.09.2016.
 */
public class EndTwoActivity extends EndActivity {

    TextView result, textView2;
    Button buttonTryAgain, buttonQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_two);

        result = (TextView) findViewById(R.id.resultView);
        textView2 = (TextView) findViewById(R.id.textView2);
        buttonTryAgain = (Button) findViewById(R.id.buttonTryAgain);
        buttonTryAgain.setOnClickListener(this);
        buttonQuit = (Button) findViewById(R.id.buttonQuit);
        buttonQuit.setOnClickListener(this);

        Intent intent = getIntent();
        String resultcore = intent.getStringExtra("resultscore");
        result.setText(resultcore);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonTryAgain:
                Intent intent = new Intent(this, GameTwoActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonQuit:
                finish();
                break;
        }
    }
}

package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity implements View.OnClickListener {

    TextView CountDown_timer_text ;
    Button CountDown_timer_button,Reset_Timer;
    private CountDownTimer mcountDownTimer;
    private long mTime_left_in_sec= 600000;
    private boolean mTimer_Running ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeractivity);
        CountDown_timer_button = findViewById(R.id.btn1);
        CountDown_timer_text =findViewById(R.id.tv2);
        Reset_Timer=findViewById(R.id.btn2);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btn1:
                startstop();
                break;
            case R.id.btn2:
                CountDown_timer_text.setText("");

        }
    }

    public void startstop(){

        mcountDownTimer = new CountDownTimer(mTime_left_in_sec,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                mTime_left_in_sec = millisUntilFinished;
                updateCountdontext();
            }

            @Override
            public void onFinish() {

              mTimer_Running =false;
              CountDown_timer_button.setText("Start");
              CountDown_timer_button.setVisibility(View.INVISIBLE);
              Reset_Timer.setVisibility(View.VISIBLE);

            }
        }.start();

    }

    public void updateCountdontext(){

    }

}
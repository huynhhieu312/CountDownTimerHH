package com.countdowncatra;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView _catraCountdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _catraCountdown = (TextView)findViewById(R.id.phatshit);
        Calendar start_calendar = Calendar.getInstance();

        Calendar end_calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date eventDate = null;
        try {
            eventDate = dateFormat.parse("2017-12-24");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date currentDate = new Date();

        end_calendar.set(2018, 12, 24); //ngay


        long total_millis = eventDate.getTime()
                - currentDate.getTime(); //total time in milliseconds



        CountDownTimer cdt = new CountDownTimer(total_millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);

                millisUntilFinished -= TimeUnit.DAYS.toMillis(days);

                long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                millisUntilFinished -= TimeUnit.HOURS.toMillis(hours);

                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes);

                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);

                _catraCountdown.setText(days + "Days :" + hours + " Hour:" + minutes + "Minute :" + seconds + "Seconds"); //You can compute the millisUntilFinished on hours/minutes/seconds
            }

            @Override
            public void onFinish() {
                _catraCountdown.setText("Finish!");
            }
        };
        cdt.start();

    }
    public  void CountDownTimerPhatshit(final TextView catraCountdown)
    {

    }
}

package com.example.stop_watch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ON_CREATE", "onCreate called");

        check_saved_instance(savedInstanceState);
        run_timer();
    }

    private void check_saved_instance(Bundle saved_instance_state) {
        if(saved_instance_state != null){
            seconds = saved_instance_state.getInt("seconds");
            running = saved_instance_state.getBoolean("running");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle saved_instance_state) {
        super.onSaveInstanceState(saved_instance_state);
        saved_instance_state.putInt("seconds", seconds);
        saved_instance_state.putBoolean("running", running);
    }

    private void run_timer() {

        final TextView timer_txt_view = findViewById(R.id.timer_txt_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                if (running) {
                    seconds++;
                }

                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = hours + " : " + minutes + " : " + secs;
                timer_txt_view.setText(time);

                handler.postDelayed(this, 1000);
            }
        });
    }

    public void start_btn_onClick(View view) {
        running = true;
    }

    public void reset_btn_onClick(View view) {
        running = false;
        seconds = 0;
    }

    public void stop_btn_onClick(View view) {
        running = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ON_START", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ON_RESUME", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ON_PAUSE", "onPause called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ON_RESTART", "onRestart called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ON_STOP", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ON_DESTROY", "onDestroy called");
    }
}

package com.predatoryshrimp.shampooreader;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Disable orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);


        //Switch switch_bad_words = findViewById(R.id.switch_bad_words);
        //switch_bad_words.setVisibility(View.VISIBLE);



        Button btn_start_reading = findViewById(R.id.button_start_reading);
        btn_start_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent readerAct = new Intent(MainActivity.this, ReaderActivity.class);
                readerAct.putExtra("EXTRA_STRING",true);
                startActivity(readerAct);
            }
        });
    }
}

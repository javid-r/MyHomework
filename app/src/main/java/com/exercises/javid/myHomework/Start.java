package com.exercises.javid.myHomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.exercises.javid.myHomework.uis.CameraActivity;
import com.exercises.javid.myHomework.uis.InstagramActivity;
import com.exercises.javid.myHomework.uis.SMSActivity;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnInsta = (Button) findViewById(R.id.btn_start_insta);
        btnInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InstagramActivity.class));
            }
        });

        Button btnSMS = (Button) findViewById(R.id.btn_start_sms);
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SMSActivity.class));
            }
        });

        Button btnCam = (Button) findViewById(R.id.btn_start_cam);
        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CameraActivity.class));
            }
        });
    }
}

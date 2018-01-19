package com.exercises.javid.myHomework.uis;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.exercises.javid.myHomework.R;

public class CameraActivity extends AppCompatActivity {

    private ToggleButton toggleFlash, toggleCam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);



        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            ((ImageView)findViewById(R.id.img_demo)).setBackgroundResource(R.drawable.img_port);
        } else {
            ((ImageView)findViewById(R.id.img_demo)).setBackgroundResource(R.drawable.img_land);
        }

        toggleFlash = findViewById(R.id.tog_btn_cam_flash);
        toggleFlash.setTextOff("");
        toggleFlash.setTextOn("");
        toggleFlash.setChecked(false);
        toggleFlash.setBackgroundResource(R.drawable.ic_flash_off_in);
        toggleFlash.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            buttonView.setBackgroundResource(R.drawable.ic_flash_on_in);
                        } else {
                            buttonView.setBackgroundResource(R.drawable.ic_flash_off_in);
                        }
                    }
                }
        );

        toggleCam = findViewById(R.id.tog_btn_cam_camera);
        toggleCam.setTextOff("");
        toggleCam.setTextOn("");
        toggleCam.setChecked(false);
        toggleCam.setBackgroundResource(R.drawable.ic_camera_rear_white);
        toggleCam.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            buttonView.setBackgroundResource(R.drawable.ic_camera_front_white);
                            toggleFlash.setChecked(false);
                            toggleFlash.setEnabled(false);
                        } else {
                            buttonView.setBackgroundResource(R.drawable.ic_camera_rear_white);
                            toggleFlash.setEnabled(true);
                        }
                    }
                }
        );

    }
}

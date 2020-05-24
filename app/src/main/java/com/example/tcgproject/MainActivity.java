package com.example.tcgproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.button_start);
        start.setOnClickListener(this);


    }
    public void onClick(View v){
        try{
        switch (v.getId()) {
            case R.id.button_start:
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
            break;
        }}catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}


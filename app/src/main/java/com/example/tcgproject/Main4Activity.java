package com.example.tcgproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

public class Main4Activity extends AppCompatActivity {
    Button Return;
    ImageView f;
    int p1,p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
f = findViewById(R.id.image);
Return = findViewById(R.id.button2);
        int image = (int)getIntent().getSerializableExtra("Winner");
        p1 = getResources().getIdentifier("winnerscreenp1" , "drawable", getPackageName());
        p2 = getResources().getIdentifier("winnerscreenp2" , "drawable", getPackageName());
        switch(image){
            case 1:
                f.setImageResource(p1);
                break;
            case 2:
                f.setImageResource(p2);
                break;
        }

        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(i);

            }
        });

    }
}

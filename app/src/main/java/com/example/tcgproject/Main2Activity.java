package com.example.tcgproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button deck1;
    Button deck2;
    Button deck3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        deck1 = (Button) findViewById(R.id.deck1);
        deck2 = (Button) findViewById(R.id.deck2);
        deck3 =(Button) findViewById(R.id.deck3);
       deck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Main5Activity.class);
                i.putExtra("p1deck",1);
                startActivity(i);
            }
        });
        deck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Main5Activity.class);
                i.putExtra("p1deck",2);
                startActivity(i);
            }
        });
        deck3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, Main5Activity.class);
                i.putExtra("p1deck",3);
                startActivity(i);
            }
        });
    }
}

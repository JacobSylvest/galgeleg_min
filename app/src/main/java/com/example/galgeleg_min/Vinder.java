package com.example.galgeleg_min;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Vinder extends AppCompatActivity /*implements View.OnClickListener */{

    Button button;
    TextView text, text2, text3;
    private Galgelogik galgelogik;
    MediaPlayer Win;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinder);
        //menu = findViewById(R.id.menuWinner2);
        String word = getIntent().getStringExtra("word");

        Win = MediaPlayer.create(getApplicationContext(),R.raw.ta_da);
        Win.start();
        galgelogik = Galgelogik.getInstance();
        text2 = findViewById(R.id.textViewX);
        text = findViewById(R.id.textViewY);
        text.setText(galgelogik.getOrdet()); //ellers eer det galgelogik.getSynligtOrd()

        text3 = findViewById(R.id.textViewZ);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_out);
        text3.startAnimation(animation);

        button = findViewById(R.id.buttonX);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Vinder.this, Galgeleg.class));
                Vinder.this.finish();
            }
        });


       /* menuIntent = new Intent(this, MainActivity.class);
        menu.setOnClickListener(this);*/
    }

    @Override
    protected void  onPause(){
        super.onPause();
        Win.release();
    }
/*
    @Override
    public void onClick(View v) {
        startActivity(menuIntent);
    }*/
}
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

public class Taber extends AppCompatActivity {

    Button button;
    TextView text, text2, text3;
    private Galgelogik galgelogik;
    MediaPlayer Lose;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taber);
        //menu = findViewById(R.id.menuWinner2);
        String word = getIntent().getStringExtra("word");

        Lose = MediaPlayer.create(getApplicationContext(),R.raw.wah_wah_sound);
        Lose.start();

        galgelogik = Galgelogik.getInstance();
        text2 = findViewById(R.id.textViewA);
        text = findViewById(R.id.textViewB);
        text.setText(galgelogik.getOrdet()); //ellers er det galgelogik.getSynligtOrd()

        text3 = findViewById(R.id.textViewC);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_out);
        text3.startAnimation(animation);

        button = findViewById(R.id.buttonA);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Taber.this, Galgeleg.class));
                Taber.this.finish();
            }
        });

    }

    @Override
    protected void  onPause(){
        super.onPause();
        Lose.release();
    }
}
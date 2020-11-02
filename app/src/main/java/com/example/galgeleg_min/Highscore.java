package com.example.galgeleg_min;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Highscore extends AppCompatActivity implements View.OnClickListener {
    TextView msg;
    Button back;
    String notImplementedMsg;
    Intent intent;
    Galgelogik galgelogik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        back = findViewById(R.id.goToMainMenu2);
        msg = findViewById(R.id.highscoreTextView);

        galgelogik.getList();

        notImplementedMsg = "Ikke implementeret endnu!";
        msg.setText(notImplementedMsg);

        back.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
package com.example.galgeleg_min;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startNewGame, startNewMltpGame, help, highscore;
    Intent newGameIntent, helpIntent, highscoreIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGameIntent = new Intent(this, Galgeleg.class);
        helpIntent = new Intent(this, HelpMenu.class);
        highscoreIntent = new Intent(this, Highscore.class);

        startNewGame = findViewById(R.id.startGame);
        startNewMltpGame = findViewById(R.id.startGame2);
        help = findViewById(R.id.helpButton);
        highscore = findViewById(R.id.highScore);

        startNewGame.setOnClickListener(this);
        startNewMltpGame.setOnClickListener(this);
        help.setOnClickListener(this);
        highscore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == startNewGame) {
            startActivity(newGameIntent);
        }
        else if (v == startNewMltpGame) {
            startActivity(newGameIntent);
        }
        else if (v == help) {
            startActivity(helpIntent);
        }
        else if (v == highscore) {
            startActivity(highscoreIntent);
        }
    }
}
package com.example.galgeleg_min;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Galgeleg extends AppCompatActivity implements View.OnClickListener {

    Button guess;
    Button endGame;
    Button newGame;

    TextView secretWord;
    TextView feedbackText;
    TextView usedLetters;
    TextView nmbrOfWrongGuesses;
    TextView gameOutcomeMsg;

    EditText editText;

    Galgelogik galgelogik;

    ImageView imageView;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galgeleg);

        galgelogik = new Galgelogik();
        editText = findViewById(R.id.editText);

        //Buttons
        newGame = findViewById(R.id.playAgain); //starter nyt spil
        endGame = findViewById(R.id.endGame); //afslutter spil
        guess = findViewById(R.id.tryGuessButton); //gætte knappen

        //tekst felter der giver brugeren feedback på gæt og progress
        secretWord = findViewById(R.id.secretWord);
        feedbackText = findViewById(R.id.guessFeedback);
        usedLetters = findViewById(R.id.usedLetters);
        nmbrOfWrongGuesses = findViewById(R.id.wrongGuesses);
        gameOutcomeMsg = findViewById(R.id.gameOutcomeMsg);

        //usynlige indtil spillet har et udfald
        newGame.setVisibility(View.INVISIBLE);
        endGame.setVisibility(View.INVISIBLE);
        gameOutcomeMsg.setVisibility(View.INVISIBLE);

        //sætter det hemmelige ord ved start
        String word = "Ordet er på "+galgelogik.getSynligtOrd().length()+" bogstaver";
        secretWord.setText(word);

        //sætter forkerte svar ved start
        String wrongAnswers = "forkerte svar: 0/7";
        nmbrOfWrongGuesses.setText(wrongAnswers);

        //sætter gæt ved start
        String lettersUsed = "Ingen gæt fortaget endnu";
        usedLetters.setText(lettersUsed);

        //Listeners
        guess.setOnClickListener(this);
        newGame.setOnClickListener(this);
        endGame.setOnClickListener(this);
    }
}
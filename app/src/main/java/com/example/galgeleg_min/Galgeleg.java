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

        //Text fields that gives the user feedback on progress
        secretWord = findViewById(R.id.secretWord);
        feedbackText = findViewById(R.id.guessFeedback);
        usedLetters = findViewById(R.id.usedLetters);
        nmbrOfWrongGuesses = findViewById(R.id.wrongGuesses);
        gameOutcomeMsg = findViewById(R.id.gameOutcomeMsg);

        //theese are invissible until we see a change in the game
        newGame.setVisibility(View.INVISIBLE);
        endGame.setVisibility(View.INVISIBLE);
        gameOutcomeMsg.setVisibility(View.INVISIBLE);

        //puts the word on start.
        String word = "Ordet er på "+galgelogik.getSynligtOrd().length()+" bogstaver";
        secretWord.setText(word);

        //puts wrong answer at start.
        String wrongAnswers = "forkerte svar: 0/7";
        nmbrOfWrongGuesses.setText(wrongAnswers);

        //puts n guesses at start
        String lettersUsed = "Ingen gæt fortaget endnu";
        usedLetters.setText(lettersUsed);

        //Listeners
        guess.setOnClickListener(this);
        newGame.setOnClickListener(this);
        endGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        galgelogik.gætBogstav(editText.getText().toString()); //this sends the guessed letter to the logic.

        guessedLetters(); //builds a string of used letters, and creates a area for the guessed letters.

        isGuessCorrect(); //sends message to user wether they are wright or wrong.

        isWinner(v); //win or lose?

        editText.setText(""); // edittext gets cleared between guesses.

        startNewGame(v); //creates new ganme, if user chooses to.

        //Goes to menu.
        if (v == endGame) {
            finish();
            intent = new Intent(this, MainActivity.class);
        }
    }

    private void startNewGame(View v) {
        // calls the 'startNytSpil' method
        //neutralizes all values in UI and changes vissibillity on 3 buttons.
        if (v == newGame) {
            galgelogik.startNytSpil();
            secretWord.setText("Gæt igen :)");
            feedbackText.setText("");
            usedLetters.setText("");
            nmbrOfWrongGuesses.setText("");
            imageView.setImageResource(R.drawable.galge);

            newGame.setVisibility(View.INVISIBLE);
            endGame.setVisibility(View.INVISIBLE);
            gameOutcomeMsg.setVisibility(View.INVISIBLE);
        }
    }

    //builds new string of previous guesses.
    private void guessedLetters() {
        StringBuilder used;
        ArrayList<String> usedLetterList;
        used = new StringBuilder();
        usedLetterList = galgelogik.getBrugteBogstaver();
        for (int i = 0; i <= usedLetterList.size() - 1; i++) {
            used.append(usedLetterList.get(i)).append(", ");
            usedLetters.setText("Tidligere gæt:\n"+used);
        }
    }

    //hides keyboard, vissibillity of buttons, creates 'Winner / loser' message.
    private void isWinner(View v) {
        if (galgelogik.erSpilletVundet()) {
            String winnerStr = "DU VANDT!";
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            gameOutcomeMsg.setVisibility(View.VISIBLE);
            newGame.setVisibility(View.VISIBLE);
            endGame.setVisibility(View.VISIBLE);
            gameOutcomeMsg.setText(winnerStr);

        } else if (galgelogik.erSpilletTabt()) {
            secretWord.setText("Ordet var: "+galgelogik.getOrdet());
            String loserString = "DU TABTE!";
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            gameOutcomeMsg.setVisibility(View.VISIBLE);
            newGame.setVisibility(View.VISIBLE);
            endGame.setVisibility(View.VISIBLE);
            gameOutcomeMsg.setText(loserString);
        }
    }

    //Is letter right or wrong?
    private void isGuessCorrect() {
        String str,str2;
        String updateWord;
        int wrongGuesses;
        if (galgelogik.erSidsteBogstavKorrekt()) {
            str = "\"" + editText.getText() + "\"" + " var korrekt!";
            updateWord = galgelogik.getSynligtOrd();
            secretWord.setText(updateWord);
        } else {
            wrongGuesses = galgelogik.getAntalForkerteBogstaver();
            str = "\"" + editText.getText() + "\"" + " var IKKE korrekt!";
            str2 = "forkerte svar: "+wrongGuesses + "/7";
            nmbrOfWrongGuesses.setText(str2);

            imageView = findViewById(R.id.imageView);
            updateImage(wrongGuesses); //opdaterer galgen

        }
        feedbackText.setText(str);
    }

    //updates the pictures when wrong answer.
    public void updateImage(int wrongGuesses) {
        switch (wrongGuesses) {
            case 1:
            case 2:
                imageView.setImageResource(R.drawable.forkert1);
                break;
            case 3:
                imageView.setImageResource(R.drawable.forkert2);
                break;
            case 4:
                imageView.setImageResource(R.drawable.forkert3);
                break;
            case 5:
                imageView.setImageResource(R.drawable.forkert4);
                break;
            case 6:
                imageView.setImageResource(R.drawable.forkert5);
                break;
            case 7:
                imageView.setImageResource(R.drawable.forkert6);
                break;
            default:
                break;
        }
    }
}
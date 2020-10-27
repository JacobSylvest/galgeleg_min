package com.example.galgeleg_min;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpMenu extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button menuButton;
    Intent intent;
    String helpMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_menu);

        helpMsg = "- Galgleleg spilles ved at gætte på en række bogstaver. Disse skrives ind ét bogstav af gangen. Gættes der korrekt, vil det bogstav man gættede blive synligt.  \n\n" +
                "- Man har 7 forsøg på at gætte rigtigt før spillet slutter med en taberbesked. \n\n" +
                "- Der vil blive vist de bogstaver man har gættet, så man ikke benutter de samme bogstavr flere gange. ";

        textView = findViewById(R.id.helpMsg);
        menuButton = findViewById(R.id.goToMenu);

        textView.setText(helpMsg);

        menuButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
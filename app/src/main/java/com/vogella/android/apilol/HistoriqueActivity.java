package com.vogella.android.apilol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HistoriqueActivity extends AppCompatActivity {

    private String playerName;
    private Long playerId;
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        Intent intent = getIntent(); // recupérations des données
        Bundle extras = intent.getExtras();


        test = (TextView) findViewById(R.id.test);

        if(extras.getString("NAME")!= null && extras.getLong("ID") > 0){

            playerName = extras.getString("NAME");
            playerId= extras.getLong("ID");

            test.setText(playerName + "/" + String.valueOf(playerId));
        }
    }
}

package com.vogella.android.android4a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_nombre;
    private Button dé_bouton;
    private TextView textView;
    private ProgressBar progressBar;
    private TextView historique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombre =(EditText) findViewById(R.id.txt_nombre);
        dé_bouton =(Button) findViewById(R.id.dé_bouton;
       textView =(TextView) findViewById(R.id.textView);
        progressBar =(ProgressBar) findViewById(R.id.progressBar);
       historique =(TextView) findViewById(R.id.Historique);


    }

}

package com.vogella.android.android4a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumber;
    private Button btnCompare;
    private TextView lblResult;
    private ProgressBar pgbScore;
    private TextView lblHistory;


    private Button mLebouton;
    private EditText mEditText;


    private int searchedValue;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = (EditText) findViewById( R.id.txtNumber );
        btnCompare = (Button) findViewById( R.id.btnCompare );
        lblResult = (TextView) findViewById( R.id.lblResult );
        pgbScore = (ProgressBar) findViewById( R.id.pgbScore );
        lblHistory = (TextView) findViewById( R.id.lblHistory );

        mLebouton = (Button) findViewById(R.id.button_click);
        mEditText = (EditText) findViewById(R.id.editText);

        btnCompare.setOnClickListener( btnCompareListener );

        mLebouton.setEnabled(false);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLebouton.setEnabled(s.toString().length() !=0 );

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

            mLebouton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mEditText.setText("BONJOUR");
                }
            });

        init();
// Pour les différentes langues
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        double price = 1_000_000.01;
        Log.i( "DEBUG", formatter.format( price ) );

        DateFormat dataFormatter = DateFormat.getDateTimeInstance();
        Log.i( "DEBUG", dataFormatter.format( new Date() ) );
    }

    private void init() {
        score = 0;
        searchedValue = 1 + (int) (Math.random() * 100);
        Log.i( "DEBUG", "Searched value : " + searchedValue );

        // réinitialisation
        txtNumber.setText( "" );
        pgbScore.setProgress( score );
        lblResult.setText( "" );
        lblHistory.setText( "" );

        txtNumber.requestFocus();
    }

    // Fin du jeu
    private void congratulations() {
        lblResult.setText( R.string.strCongratulations );

        // POP UP  avec le résultat
        AlertDialog retryAlert = new AlertDialog.Builder( this ).create();
        retryAlert.setTitle( R.string.app_name ); // titre pop up
        retryAlert.setMessage( getString(R.string.strMessage, score ) ); // affichage du mesage avec %d pour afficher direct score dans le mssage

        retryAlert.setButton( AlertDialog.BUTTON_POSITIVE, getString(R.string.strYes), new AlertDialog.OnClickListener() { // on créer un autre onclicck listener mais par l'interface alertdialog
            @Override
            public void onClick(DialogInterface dialog, int which) {
                init(); // redemare avec la fonction init() qu'on a créé
            }
        });

        retryAlert.setButton( AlertDialog.BUTTON_NEGATIVE, getString(R.string.strNo), new AlertDialog.OnClickListener() { // meme chose pour le boutton de refus
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // quitte l'activité
            }
        });
        // affichage de la boite de dialogue
        retryAlert.show();
    }


    // quand on clique sur le bouton
    private View.OnClickListener btnCompareListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i( "DEBUG", "Button clicked" );


            String strNumber = txtNumber.getText().toString();
            if ( strNumber.equals( "" ) ) return;

            int enteredValue = Integer.parseInt( strNumber );
            lblHistory.append( strNumber + "\r\n" );
            pgbScore.incrementProgressBy( 1 ); // barre de progression
            score++;

            // jeu si + gfrand ou plus petit , message dans string
            if ( enteredValue == searchedValue ) {
                congratulations(); // lance congrat si ok
            } else if ( enteredValue < searchedValue ) {
                lblResult.setText( R.string.strGreater );
            } else {
                lblResult.setText( R.string.strLower );
            }
    // on réinitalise le focus
            txtNumber.setText( "" );
           txtNumber.requestFocus();

        }
    };




}



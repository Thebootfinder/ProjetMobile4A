package com.vogella.android.apilol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.vogella.android.apilol.request.ApiRequest;

public class MainActivity extends AppCompatActivity {

    EditText etJoueur;
    Button btnrechercher;
    ProgressBar pbLoader;
    ListView lvRecent;
    private RequestQueue queue; // appel
    private ApiRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



   queue = MySingleton.getInstance(this).getRequestQueue();

        request = new ApiRequest(queue, this );


        etJoueur = (EditText) findViewById(R.id.et_player);
        btnrechercher = (Button) findViewById(R.id.button);
        pbLoader = (ProgressBar) findViewById(R.id.pb_search);
        lvRecent = (ListView) findViewById(R.id.lv_recent);


        btnrechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //String name =  etJoueur.getText().toString();
                //Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show(); // toast pour afficher du text en flash
                String recherche = etJoueur.getText().toString().trim(); // Trim enleve espace début et fin de chaine de caratère
                if(recherche.length() > 0 ){

                    request.checkPlayerName(recherche, new ApiRequest.CheckPlayerCallBack() {
                        @Override
                        public void onSucess(String name, long id) {

                            Intent intent = new Intent(getApplicationContext(), HistoriqueActivity.class);  // Pour passer dans l'autre activité
                            Bundle extras = new Bundle();
                            extras.putString("NAME", name);
                            extras.putLong("ID", id);
                            intent.putExtras(extras);
                            startActivity(intent);
                        }

                        @Override
                        public void dontExist(String message) {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(String message) {
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        }
                    });

                }else {
                    Toast.makeText(getApplicationContext(), "Vous devez taper un nom de joueur", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

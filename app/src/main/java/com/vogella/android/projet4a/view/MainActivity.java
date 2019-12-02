package com.vogella.android.projet4a.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vogella.android.projet4a.AnimeFragment;
import com.vogella.android.projet4a.R;
import com.vogella.android.projet4a.controller.MainController;
import com.vogella.android.projet4a.model.Anime;
import com.vogella.android.projet4a.view.MyAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFragment(new AnimeFragment());
    }

    private void showFragment (AnimeFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentView, fragment)
                .commit();
    }











    /*
        private RecyclerView recyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            MainController mainController = new MainController(this);
            mainController.onCreate();



        }

    public void showList(List<Anime> input) {

        recyclerView = findViewById(R.id.my_recycler_view);
     //   RecyclerView recyclerView = getView().findViewById(R.id.my_recycler_view);



        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // define an adapter
        mAdapter = new MyAdapter(input, this);
        recyclerView.setAdapter(mAdapter);
    }*/
}

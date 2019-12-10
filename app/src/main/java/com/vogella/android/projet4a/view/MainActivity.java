package com.vogella.android.projet4a.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vogella.android.projet4a.R;
import com.vogella.android.projet4a.view.AnimeView.AnimeFragment;
import com.vogella.android.projet4a.view.MangaView.MangaFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.movie_list:
                showFragment(new AnimeFragment());
                return true;
            case R.id.to_see:
                showFragment(new MangaFragment());
                return true;
            case R.id.favorites:
               showFragment(new AnimeFragment());
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFragment(new AnimeFragment());
    }

    private void showFragment (Fragment fragment) {
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

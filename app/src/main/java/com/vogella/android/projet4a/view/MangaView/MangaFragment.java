package com.vogella.android.projet4a.view.MangaView;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vogella.android.projet4a.R;
import com.vogella.android.projet4a.controller.MangeController.MangaController;
import com.vogella.android.projet4a.model.MangaModel.Manga;
import com.vogella.android.projet4a.view.DetailActivity;
import com.vogella.android.projet4a.view.MyAdapter;

import java.util.List;

public class MangaFragment extends Fragment {


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes*/
    public MangaFragment() {
    }

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga_list, container, false);
        // Inflate the layout for this fragment


        MangaController mangaController = new MangaController(this);
        mangaController.onCreate();


        return view;


    }

    public void showList(List<Manga> input) {
        RecyclerView recyclerView = getView().findViewById(R.id.my_recycler_view2);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);



       RecyclerView.Adapter mAdapter = new AdapterManga(input, getActivity(), new AdapterManga.OnItemClickListener() {
            @Override
           public void onItemClick(Manga item) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra(AdapterManga.ID_MANGA, item.getMalId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);

       /*
        recyclerView = getView().findViewById(R.id.my_recycler_view);
        //   RecyclerView recyclerView = getView().findViewById(R.id.my_recycler_view);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // define an adapter
        mAdapter = new MyAdapter(input,getActivity());
        recyclerView.setAdapter(mAdapter);*/
    }


}

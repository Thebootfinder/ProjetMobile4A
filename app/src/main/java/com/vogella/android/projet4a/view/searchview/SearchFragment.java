package com.vogella.android.projet4a.view.searchview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vogella.android.projet4a.R;
import com.vogella.android.projet4a.controller.searchcontroller.SearchController;
import com.vogella.android.projet4a.model.searchmodel.Search;
import com.vogella.android.projet4a.view.animeview.DetailActivity;

import java.util.List;

public class SearchFragment extends Fragment {


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes
     */
    public SearchFragment() {
    }

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);
        // Inflate the layout for this fragment


        SearchController searchController = new SearchController(this);
        searchController.onCreate();


        return view;


    }

    public void showList(List<Search> input) {
        RecyclerView recyclerView = getView().findViewById(R.id.my_recycler_view_search);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        Log.d("ERREUR", "ok2.");
        RecyclerView.Adapter mAdapter = new AdapterSearch( input, getActivity(), new AdapterSearch.OnItemClickListener() {
            @Override
            public void onItemClick(Search item) {
                Log.d("ERREUR", "ok3.");
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra(AdapterSearch.ID_SEARCH, item.getMalId());
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

package com.vogella.android.projet4a.view.MangaView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vogella.android.projet4a.R;
import com.vogella.android.projet4a.controller.MangaController.MangaController;
import com.vogella.android.projet4a.model.MangaModel.Manga;
import com.vogella.android.projet4a.view.AnimeView.DetailActivity;

import java.util.List;

public class ThreeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.row_layout_three_activity,
                container, false);

        return view;
    }
}






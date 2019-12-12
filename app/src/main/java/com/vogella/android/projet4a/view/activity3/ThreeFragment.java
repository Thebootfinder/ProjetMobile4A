package com.vogella.android.projet4a.view.activity3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.vogella.android.projet4a.R;

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






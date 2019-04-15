package com.example.niccopark.fragment.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.niccopark.R;
import com.example.niccopark.adapter.RidesAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyRidesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public FamilyRidesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_family_rides, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rides_rv);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RidesAdapter(getContext());
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

}

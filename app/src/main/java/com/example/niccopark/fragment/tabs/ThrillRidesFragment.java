package com.example.niccopark.fragment.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.niccopark.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThrillRidesFragment extends Fragment {


    public ThrillRidesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thrill_rides, container, false);
    }

}

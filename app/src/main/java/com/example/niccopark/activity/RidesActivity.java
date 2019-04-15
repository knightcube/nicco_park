package com.example.niccopark.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.niccopark.R;
import com.example.niccopark.adapter.RidesTabAdapter;
import com.example.niccopark.fragment.tabs.FamilyRidesFragment;
import com.example.niccopark.fragment.tabs.KidsRidesFragment;
import com.example.niccopark.fragment.tabs.ThrillRidesFragment;

public class RidesActivity extends AppCompatActivity {

    private RidesTabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        adapter = new RidesTabAdapter(getSupportFragmentManager());
        adapter.addFragment(new FamilyRidesFragment(), "Family Rides");
        adapter.addFragment(new FamilyRidesFragment(), "Kids Rides");
        adapter.addFragment(new FamilyRidesFragment(), "Thrill Rides");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

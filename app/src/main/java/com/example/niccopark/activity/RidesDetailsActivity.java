package com.example.niccopark.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.niccopark.R;
import com.example.niccopark.model.Rides;

public class RidesDetailsActivity extends AppCompatActivity {

    private ImageView ridesDetailsImage;
    private TextView ridesDetailsTitleTxt;
    private TextView ridesDetailsDescriptionTxt;
    private TextView ridesShowMapTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rides_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        ridesDetailsImage = findViewById(R.id.rides_details_images);
        ridesDetailsTitleTxt = findViewById(R.id.rides_details_title_txt);
        ridesDetailsDescriptionTxt = findViewById(R.id.rides_details_desc_txt);
        ridesShowMapTxt = findViewById(R.id.show_map_txt);

        Rides currentRide = (Rides) getIntent().getSerializableExtra("SELECTED_RIDE");
        Glide.with(this).load(currentRide.getImageUrl()).into(ridesDetailsImage);
        ridesDetailsTitleTxt.setText(currentRide.getTitle());
        actionbar.setTitle(currentRide.getTitle());
        ridesDetailsDescriptionTxt.setText(currentRide.getDescription());
    }
}

package com.example.niccopark.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niccopark.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class HomeScreenActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private SliderLayout sliderLayout;
    public TextView attractionsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        dl = (DrawerLayout)findViewById(R.id.activity_home_drawer);
        sliderLayout = findViewById(R.id.imageSlider);
        attractionsBtn = findViewById(R.id.attractions_btn);

        setSliderViews();
        initDrawer();
        attractionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreenActivity.this,AttractionsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initDrawer() {
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        t.getDrawerArrowDrawable().setColor(Color.WHITE);
        dl.addDrawerListener(t);
        t.syncState();

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.home:
                        Toast.makeText(HomeScreenActivity.this, "Home",Toast.LENGTH_SHORT).show();
                    case R.id.attractions: {
                        Toast.makeText(HomeScreenActivity.this, "Opening Attractions", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HomeScreenActivity.this, AttractionsActivity.class);
                        startActivity(intent);
                    }
                    default:
                        return true;
                }

            }
        });
    }

    private void setSliderViews() {

        sliderLayout.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(5); //set scroll delay in seconds :

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(HomeScreenActivity.this);

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://i2.wp.com/niccoparks.com/wp-content/uploads/2018/08/Park-Packags.jpg?w=596&ssl=1");
                    break;
                case 1:
                    sliderView.setImageUrl("https://i1.wp.com/niccoparks.com/wp-content/uploads/formidable/29/seasonal-offer.jpg?fit=700%2C436&ssl=1");
                    break;
                case 2:
                    sliderView.setImageUrl("https://i1.wp.com/niccoparks.com/wp-content/uploads/formidable/water-chute.jpg?fit=605%2C394&ssl=1");
                    break;
                case 3:
                    sliderView.setImageUrl("https://i.ytimg.com/vi/D7I0ss7uUxM/maxresdefault.jpg");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(HomeScreenActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;


        if(item.getItemId() == R.id.attractions){
            Toast.makeText(this, "Attractions Selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeScreenActivity.this,AttractionsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
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
import android.widget.Button;
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
    private Button ridesBtn;
    private Button buyTicketsBtn;
    private Button eventsBtn;
    private Button subscribeBtn;
    private TextView subscriptionStatus;
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
        ridesBtn = findViewById(R.id.rides_btn);
        buyTicketsBtn = findViewById(R.id.buy_tickets_btn);
        eventsBtn = findViewById(R.id.events_btn);
        subscribeBtn = findViewById(R.id.subscribe_btn);
        subscriptionStatus = findViewById(R.id.subscription_status);

        setSliderViews();
        initDrawer();
        attractionsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeScreenActivity.this,AttractionsActivity.class);
            startActivity(intent);
        });

        ridesBtn.setOnClickListener(v->{
            Intent intent = new Intent(HomeScreenActivity.this,RidesActivity.class);
            startActivity(intent);
        });
        buyTicketsBtn.setOnClickListener(v->{
            Intent intent = new Intent(HomeScreenActivity.this, PaymentsActivity.class);
            startActivity(intent);
        });
        eventsBtn.setOnClickListener(v->{
            Intent intent = new Intent(HomeScreenActivity.this, RidesActivity.class);
            startActivity(intent);
        });
        subscribeBtn.setOnClickListener(v->{
            subscribeBtn.setVisibility(View.GONE);
            subscriptionStatus.setVisibility(View.VISIBLE);
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
                    case R.id.events: {
                        Toast.makeText(HomeScreenActivity.this, "Opening Events", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HomeScreenActivity.this, RidesActivity.class);
                        startActivity(intent);
                    }
                    case R.id.rides: {
                        Toast.makeText(HomeScreenActivity.this, "Opening Rides", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HomeScreenActivity.this, RidesActivity.class);
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


//        if(item.getItemId() == R.id.events){
//            Toast.makeText(this, "Events Selected", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(HomeScreenActivity.this,RidesActivity.class);
//            startActivity(intent);
//            return true;
//        }
//        else if(item.getItemId() == R.id.rides){
//            Toast.makeText(this, "Rides Selected", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(HomeScreenActivity.this,RidesActivity.class);
//            startActivity(intent);
//            return true;
//        }else if(item.getItemId() == R.id.home){
//            Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(HomeScreenActivity.this,HomeScreenActivity.class);
//            startActivity(intent);
//            return true;
//        }


        return super.onOptionsItemSelected(item);
    }
}

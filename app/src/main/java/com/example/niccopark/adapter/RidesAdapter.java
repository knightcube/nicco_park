package com.example.niccopark.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.niccopark.R;
import com.example.niccopark.activity.RidesDetailsActivity;
import com.example.niccopark.model.Rides;

import java.util.List;

public class RidesAdapter extends RecyclerView.Adapter<RidesAdapter.RidesViewHolder> {

    private List<Rides> ridesList;
    private Context context;
    private int category;

    public RidesAdapter(List<Rides> ridesList, Context context, int category) {
        this.ridesList = ridesList;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public RidesAdapter.RidesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rides_2, parent, false);
        RidesViewHolder ridesViewHolder = new RidesViewHolder(view);
        return ridesViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RidesAdapter.RidesViewHolder ridesViewHolder, int i) {

        Rides currentRide = ridesList.get(i);
        if(currentRide.getCategory() == this.category){
            ridesViewHolder.rideCard.setVisibility(View.VISIBLE);
            ridesViewHolder.rideTitle.setText(currentRide.getTitle());
            ridesViewHolder.rideDescription.setText(currentRide.getDescription());
            Glide.with(context).load(currentRide.getImageUrl()).into(ridesViewHolder.rideImage);
        }else{
            ridesViewHolder.rideCard.setVisibility(View.GONE);
        }


        ridesViewHolder.moreBtn.setOnClickListener(v->{
            Intent intent = new Intent(context,RidesDetailsActivity.class);
            context.startActivity(intent);
        });
        ridesViewHolder.rideCard.setOnClickListener(v->{
            Intent intent = new Intent(context,RidesDetailsActivity.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return ridesList.size();
    }



    public static class RidesViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private Button moreBtn;
        private CardView rideCard;
        private TextView rideTitle;
        private TextView rideDescription;
        private ImageView rideImage;
        public RidesViewHolder(View v) {
            super(v);
            rideTitle = v.findViewById(R.id.ride_title);
            rideDescription = v.findViewById(R.id.ride_description);
            moreBtn = v.findViewById(R.id.more_btn);
            rideCard = v.findViewById(R.id.ride_card_view);
            rideImage = v.findViewById(R.id.media_image);
        }
    }

}

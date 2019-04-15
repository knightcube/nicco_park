package com.example.niccopark.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.niccopark.R;
import com.example.niccopark.activity.RidesDetailsActivity;

public class RidesAdapter extends RecyclerView.Adapter<RidesAdapter.RidesViewHolder> {

    private Context context;

    public RidesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RidesAdapter.RidesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rides, parent, false);
        RidesViewHolder ridesViewHolder = new RidesViewHolder(view);
        return ridesViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RidesAdapter.RidesViewHolder ridesViewHolder, int i) {
        ridesViewHolder.moreTxt.setOnClickListener(v->{
            Intent intent = new Intent(context,RidesDetailsActivity.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }



    public static class RidesViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView moreTxt;
        public RidesViewHolder(View v) {
            super(v);
            moreTxt = v.findViewById(R.id.more_txt);
        }
    }

}

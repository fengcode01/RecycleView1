package com.example.recycleviewdemo.model;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MacDataAdapter extends RecyclerView.Adapter {

    int[] images;
    String [] products;
    int [] prices;

    public MacDataAdapter() {
        WebDataSource ds = new WebDataSource();
        this.images = ds.getImage();
        this.products = ds.getMenu();
        this.prices = ds.getPrice();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

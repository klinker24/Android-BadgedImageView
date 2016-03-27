package com.klinker.android.badged_imageview_example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klinker.android.badged_imageview.BadgedImageView;
import com.klinker.android.badged_imageview_example.R;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public BadgedImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (BadgedImageView) itemView.findViewById(R.id.image_view);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View contactView = LayoutInflater.from(context)
                .inflate(R.layout.adapter_item, parent, false);

        return new ViewHolder(contactView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.imageView.setBadge("Test " + position);
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return 100;
    }
}

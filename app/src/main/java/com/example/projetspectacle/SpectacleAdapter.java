package com.example.projetspectacle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetspectacle.models.Spectacle;

import java.util.List;

public class SpectacleAdapter extends RecyclerView.Adapter<SpectacleAdapter.SpectacleViewHolder> {
    private List<Spectacle> spectacleList;
    private final OnSpectacleClickListener listener;

    public interface OnSpectacleClickListener {
        void onSpectacleClick(Spectacle spectacle);
        void onBookButtonClick(Spectacle spectacle);
    }

    public SpectacleAdapter(List<Spectacle> spectacleList, OnSpectacleClickListener listener) {
        this.spectacleList = spectacleList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SpectacleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spectacle, parent, false);
        return new SpectacleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpectacleViewHolder holder, int position) {
        Spectacle spectacle = spectacleList.get(position);
        holder.bind(spectacle, listener);
    }

    @Override
    public int getItemCount() {
        return spectacleList.size();
    }

    public void updateData(List<Spectacle> newSpectacles) {
        spectacleList.clear();
        spectacleList.addAll(newSpectacles);
        notifyDataSetChanged();
    }

    public static class SpectacleViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView titleText;
        private final TextView dateText;
        private final TextView locationText;
        private final TextView priceText;
        private final Button bookButton;

        public SpectacleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleText = itemView.findViewById(R.id.titleText);
            dateText = itemView.findViewById(R.id.dateText);
            locationText = itemView.findViewById(R.id.locationText);
            priceText = itemView.findViewById(R.id.priceText);
            bookButton = itemView.findViewById(R.id.bookButton);
        }

        public void bind(final Spectacle spectacle, final OnSpectacleClickListener listener) {
            // Set text values
            titleText.setText(spectacle.getTitre());
            dateText.setText(spectacle.getFormattedDateTime());
            locationText.setText(spectacle.getLieu());
            priceText.setText(spectacle.getFormattedPrice());

            // Load image from drawable resources
            loadSpectacleImage(spectacle.getImage());

            // Set click listeners
            itemView.setOnClickListener(v -> listener.onSpectacleClick(spectacle));
            bookButton.setOnClickListener(v -> listener.onBookButtonClick(spectacle));
        }

        private void loadSpectacleImage(String imageName) {
            if (imageName == null || imageName.isEmpty()) {
                imageView.setImageResource(R.drawable.default_image);
                return;
            }

            // Remove file extension if present
            String resourceName = imageName
                    .replace(".png", "")
                    .replace(".jpg", "")
                    .replace(".jpeg", "");

            // Get resource identifier
            int resId = itemView.getContext().getResources()
                    .getIdentifier(resourceName, "drawable", itemView.getContext().getPackageName());

            // Set image if found, otherwise use default
            if (resId != 0) {
                imageView.setImageResource(resId);
            } else {
                imageView.setImageResource(R.drawable.default_image);
            }
        }
    }
}
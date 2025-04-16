package com.example.projetspectacle;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class spectacleadapter extends RecyclerView.Adapter<spectacleadapter.ViewHolder> {
    private List<spectacle> spectacleList;

    public spectacleadapter(List<spectacle> spectacleList) {
        this.spectacleList = spectacleList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleText, dateText, locationText;
        Button bookButton;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleText = itemView.findViewById(R.id.titleText);
            dateText = itemView.findViewById(R.id.dateText);
            locationText = itemView.findViewById(R.id.locationText);
            bookButton = itemView.findViewById(R.id.bookButton);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spectacle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        spectacle spectacle = spectacleList.get(position);

        holder.titleText.setText(spectacle.getTitre());
        holder.dateText.setText(spectacle.getDate());
        holder.locationText.setText(spectacle.getLieu());
        holder.imageView.setImageResource(spectacle.getImageResId());

        // 1. Clic sur TOUT l'élément -> Détails
        holder.itemView.setOnClickListener(v -> {
            Intent detailIntent = new Intent(v.getContext(), EventDetailActivity.class);
            detailIntent.putExtra("titre", spectacle.getTitre());
            detailIntent.putExtra("date", spectacle.getDate());
            detailIntent.putExtra("lieu", spectacle.getLieu());
            detailIntent.putExtra("imageResId", spectacle.getImageResId());
            detailIntent.putExtra("description", spectacle.getDescription());
            detailIntent.putExtra("placesRestantes", spectacle.getPlacesRestantes());
            detailIntent.putExtra("prix", spectacle.getPrix());
            v.getContext().startActivity(detailIntent);
        });

        // 2. Clic sur le BOUTON Réserver -> Réservation directe
        holder.bookButton.setOnClickListener(v -> {
            Intent reservationIntent = new Intent(v.getContext(), activity_reservation.class);
            reservationIntent.putExtra("titre", spectacle.getTitre());
            reservationIntent.putExtra("date", spectacle.getDate());
            reservationIntent.putExtra("lieu", spectacle.getLieu());
            reservationIntent.putExtra("prix", spectacle.getPrix());
            reservationIntent.putExtra("imageResId", spectacle.getImageResId());
            v.getContext().startActivity(reservationIntent);
        });
    }

    @Override
    public int getItemCount() {
        return spectacleList.size();
    }
}
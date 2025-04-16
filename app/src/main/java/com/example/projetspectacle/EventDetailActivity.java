package com.example.projetspectacle;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        // Initialisation des vues
        ImageView eventImage = findViewById(R.id.eventImage);
        TextView eventTitle = findViewById(R.id.eventTitle);
        TextView eventDate = findViewById(R.id.eventDate);
        TextView eventLocation = findViewById(R.id.eventLocation);
        TextView remainingSeats = findViewById(R.id.remainingSeats);
        TextView eventPrice = findViewById(R.id.eventPrice);
        TextView eventDescription = findViewById(R.id.eventDescription);
        ImageButton backButton = findViewById(R.id.backButton);

        // Récupération des données de l'intent
        String titre = getIntent().getStringExtra("titre");
        String date = getIntent().getStringExtra("date");
        String lieu = getIntent().getStringExtra("lieu");
        int imageResId = getIntent().getIntExtra("imageResId", android.R.drawable.ic_menu_gallery);

        // Affichage des données disponibles
        eventTitle.setText(titre);
        eventDate.setText(date);
        eventLocation.setText(lieu);
        eventImage.setImageResource(imageResId);

        // Données statiques pour les champs manquants
        eventDescription.setText("Description non disponible pour ce spectacle.");
        remainingSeats.setText("N/A");
        eventPrice.setText("N/A");

        // Bouton retour
        backButton.setOnClickListener(v -> finish());
    }
}
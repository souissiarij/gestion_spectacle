package com.example.projetspectacle;



import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_reservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        // Initialisation des vues
        TextView eventTitle = findViewById(R.id.eventTitle);
        TextView eventDate = findViewById(R.id.eventDate);
        Button confirmButton = findViewById(R.id.confirmButton);
        ImageButton backButton = findViewById(R.id.backButton);

        // Récupérer les données de l'intent
        String titre = getIntent().getStringExtra("titre");
        String date = getIntent().getStringExtra("date");

        // Afficher les données de l'événement
        eventTitle.setText(titre);
        eventDate.setText(date);

        // Bouton retour
        backButton.setOnClickListener(v -> finish());

        // Bouton de confirmation
        confirmButton.setOnClickListener(v -> {
            Toast.makeText(this, "Paiement confirmé!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
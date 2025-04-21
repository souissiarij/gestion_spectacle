package com.example.projetspectacle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetspectacle.Retrofit.RetrofitClient;
import com.example.projetspectacle.api.ApiService;
import com.example.projetspectacle.models.Spectacle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SpectacleAdapter.OnSpectacleClickListener {

    private RecyclerView recyclerView;
    private SpectacleAdapter adapter;
    private List<Spectacle> spectacleList = new ArrayList<>();
    private static final String TAG = "MainActivity"; // Pour les logs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation du RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialisation de l'adapter
        adapter = new SpectacleAdapter(spectacleList, this);
        recyclerView.setAdapter(adapter);

        // Chargement des données
        loadSpectacles();
    }

    private void loadSpectacles() {
        ApiService apiService = RetrofitClient.getApiService();
        Call<List<Spectacle>> call = apiService.getAllSpectacles();

        call.enqueue(new Callback<List<Spectacle>>() {
            @Override
            public void onResponse(Call<List<Spectacle>> call, Response<List<Spectacle>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    spectacleList.clear();
                    spectacleList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Aucun spectacle trouvé", Toast.LENGTH_SHORT).show();
                    Log.w(TAG, "Réponse reçue mais pas réussie. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Spectacle>> call, Throwable t) {
                // Log complet de l'erreur
                Log.e(TAG, "Erreur lors de l'appel API", t);
                Toast.makeText(MainActivity.this, "Erreur de connexion: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSpectacleClick(Spectacle spectacle) {
        Intent intent = new Intent(this, EventDetailActivity.class);
        intent.putExtra("id", spectacle.getId());
        intent.putExtra("titre", spectacle.getTitre());
        intent.putExtra("date", spectacle.getDate());
        intent.putExtra("heureDebut", spectacle.getHeureDebut());
        intent.putExtra("duree", spectacle.getDuree());
        intent.putExtra("description", spectacle.getDescription());
        intent.putExtra("prix", spectacle.getPrix());
        intent.putExtra("image", spectacle.getImage());
        intent.putExtra("lieu", spectacle.getLieu());
        startActivity(intent);
    }

    @Override
    public void onBookButtonClick(Spectacle spectacle) {
        Intent intent = new Intent(this, activity_reservation.class);
        intent.putExtra("id", spectacle.getId());
        intent.putExtra("titre", spectacle.getTitre());
        intent.putExtra("date", spectacle.getDate());
        intent.putExtra("heureDebut", spectacle.getHeureDebut());
        intent.putExtra("prix", spectacle.getPrix());
        intent.putExtra("image", spectacle.getImage());
        startActivity(intent);
    }
}

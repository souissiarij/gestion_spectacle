package com.example.projetspectacle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<spectacle> spectacleList = new ArrayList<>();
        spectacleList.add(new spectacle("Comédie Musicale", "15 avril 2025", "Tunis", R.drawable.spec1));
        spectacleList.add(new spectacle("Stand-up Show", "20 avril 2025", "Sfax", R.drawable.spec2));
        spectacleList.add(new spectacle("Spectacle de magie", "22 avril 2025", "Nabeul", R.drawable.spec3));

        spectacleadapter adapter = new spectacleadapter(spectacleList);
        recyclerView.setAdapter(adapter);
    }
}
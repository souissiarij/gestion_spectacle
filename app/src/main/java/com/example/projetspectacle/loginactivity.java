package com.example.projetspectacle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class loginactivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput;
    private Button loginButton, registerButton; // Changé ici pour registerButton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        // Initialisation des vues
        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton); // Changé ici pour registerButton

        // Gestion du clic sur le bouton de connexion
        loginButton.setOnClickListener(v -> handleLogin());

        // Gestion du clic sur le bouton d'inscription
        registerButton.setOnClickListener(v -> {
            Intent registerIntent = new Intent(loginactivity.this, RegisterActivity.class);
            startActivity(registerIntent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });
    }

    private void handleLogin() {
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (username.isEmpty()) {
            usernameInput.setError("Nom d'utilisateur requis");
            usernameInput.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Mot de passe requis");
            passwordInput.requestFocus();
            return;
        }

        Toast.makeText(this, "Connexion en cours...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(loginactivity.this, MainActivity.class));
        finish();
    }
}
package com.example.projetspectacle.api;

import com.example.projetspectacle.models.Client;
import com.example.projetspectacle.models.Spectacle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    // Endpoint pour l'inscription
    @POST("/api/clients/signup")
    Call<String> registerClient(@Body Client client);

    // Endpoints pour les spectacles
    @GET("/api/spectacles/all")
    Call<List<Spectacle>> getAllSpectacles();

    @GET("/api/spectacles/{id}")
    Call<Spectacle> getSpectacleById(@Path("id") Long id);
}

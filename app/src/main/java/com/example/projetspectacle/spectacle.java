package com.example.projetspectacle;

public class spectacle {
    private String titre;
    private String date;
    private String lieu;
    private int imageResId;
    private String description; // Nouveau champ
    private int placesRestantes; // Nouveau champ
    private String prix; // Nouveau champ

    // Constructeur original (pour compatibilité)
    public spectacle(String titre, String date, String lieu, int imageResId) {
        this(titre, date, lieu, imageResId, "Description non disponible", 0, "N/A");
    }

    // Nouveau constructeur complet
    public spectacle(String titre, String date, String lieu, int imageResId,
                     String description, int placesRestantes, String prix) {
        this.titre = titre;
        this.date = date;
        this.lieu = lieu;
        this.imageResId = imageResId;
        this.description = description;
        this.placesRestantes = placesRestantes;
        this.prix = prix;
    }

    // Getters existants
    public String getTitre() { return titre; }
    public String getDate() { return date; }
    public String getLieu() { return lieu; }
    public int getImageResId() { return imageResId; }

    // Nouveaux getters
    public String getDescription() { return description; }
    public int getPlacesRestantes() { return placesRestantes; }
    public String getPrix() { return prix; }

    // Setters optionnels
    public void setDescription(String description) { this.description = description; }
    public void setPlacesRestantes(int placesRestantes) { this.placesRestantes = placesRestantes; }
    public void setPrix(String prix) { this.prix = prix; }
}
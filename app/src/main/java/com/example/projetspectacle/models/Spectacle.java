package com.example.projetspectacle.models;


public class Spectacle {
    private Long id;
    private String titre;
    private String date;
    private String heureDebut;
    private String duree;
    private String description;
    private double prix;
    private String image; // URL de l'image
    private String lieu; // Nom du lieu

    // Constructeur
    public Spectacle(Long id, String titre, String date, String heureDebut,
                     String duree, String description, double prix,
                     String image, String lieu) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.heureDebut = heureDebut;
        this.duree = duree;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.lieu = lieu;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitre() { return titre; }
    public String getDate() { return date; }
    public String getHeureDebut() { return heureDebut; }
    public String getDuree() { return duree; }
    public String getDescription() { return description; }
    public double getPrix() { return prix; }
    public String getImage() { return image; }
    public String getLieu() { return lieu; }

    // Méthode pour formater le prix
    public String getFormattedPrice() {
        return String.format("%.2f€", prix);
    }

    // Méthode pour formater la date et heure
    public String getFormattedDateTime() {
        return date + " - " + heureDebut;
    }
}
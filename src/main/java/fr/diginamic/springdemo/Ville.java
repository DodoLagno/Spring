package fr.diginamic.springdemo;

// Ville.java
public class Ville {

    private String nom;
    private String pays;

    public Ville() {
        // Constructeur par défaut requis par Spring pour la désérialisation JSON
    }

    public Ville(String nom, String pays) {
        this.nom = nom;
        this.pays = pays;
    }

    // Getters et setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}

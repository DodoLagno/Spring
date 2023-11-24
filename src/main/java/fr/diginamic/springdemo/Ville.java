package fr.diginamic.springdemo;

public class Ville {

    private String nom;
    private String pays;

    public Ville(String nom, String pays) {
        this.nom = nom;
        this.pays = pays;
    }

    // Ajoutez les getters et setters nécessaires

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


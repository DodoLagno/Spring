package fr.diginamic.springdemo;

import jakarta.persistence.*;

@Entity
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String pays;

    private int population;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    // Constructeur sans paramètre requis par JPA
    public Ville() {
    }

    public Ville(String nom, String pays) {
        this.nom = nom;
        this.pays = pays;
    }

    public Long getId() {
        return id;
    }

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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    // Override toString() pour une meilleure représentation lors du débogage
    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", departement=" + departement +
                '}';
    }

    public void setId(String pays) {
    }

    // Vous pouvez ajouter d'autres méthodes ou annotations au besoin
}

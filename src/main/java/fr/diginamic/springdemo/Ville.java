package fr.diginamic.springdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String pays;

    @ManyToOne
    @JoinColumn(name = "departement_id") // Assurez-vous que le nom de la colonne est correct
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

    // Vous pouvez ajouter d'autres méthodes ou annotations au besoin
}

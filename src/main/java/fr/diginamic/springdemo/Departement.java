package fr.diginamic.springdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int code;

    @OneToMany(mappedBy = "departement")
    private List<Ville> villes;

    public Departement() {
    }

    public Object getNom() {
        return null;
    }

    public Object getCode() {
        return null;
    }

    public void setCode(Object code) {
    }

    public void setNom(Object nom) {
    }

    // Getters et setters
}

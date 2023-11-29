package fr.diginamic.springdemo.services;

import fr.diginamic.springdemo.Departement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class DepartementService {

    @PersistenceContext
    private EntityManager em;

    public ResponseEntity<List<Departement>> extractDepartements() {
        TypedQuery<Departement> query = em.createQuery("SELECT d FROM Departement d", Departement.class);
        return ResponseEntity.ok(query.getResultList());
    }

    public ResponseEntity<Departement> extractDepartement(int idDepartement) {
        Departement departement = em.find(Departement.class, idDepartement);
        return ResponseEntity.ok(departement);
    }

    public ResponseEntity<Departement> extractDepartement(String nom) {
        TypedQuery<Departement> query = em.createQuery("SELECT d FROM Departement d WHERE d.nom = :nom", Departement.class);
        query.setParameter("nom", nom);
        Departement departement = query.getSingleResult();
        return ResponseEntity.ok(departement);
    }

    @Transactional
    public ResponseEntity<String> insertDepartement(Departement nvDepartement) {
        em.persist(nvDepartement);
        return ResponseEntity.ok("Département inséré avec succès");
    }

    @Transactional
    public ResponseEntity<String> modifierDepartement(int idDepartement, Departement departementModifiee) {
        Departement departementFromDB = em.find(Departement.class, idDepartement);
        if (departementFromDB != null) {
            departementFromDB.setNom(departementModifiee.getNom());
            departementFromDB.setCode(departementModifiee.getCode());
            return ResponseEntity.ok("Département modifié avec succès");
        } else {
            return ResponseEntity.badRequest().body("Département non trouvé");
        }
    }

    @Transactional
    public ResponseEntity<String> supprimerDepartement(int idDepartement) {
        Departement departementFromDB = em.find(Departement.class, idDepartement);
        if (departementFromDB != null) {
            em.remove(departementFromDB);
            return ResponseEntity.ok("Département supprimé avec succès");
        } else {
            return ResponseEntity.badRequest().body("Département non trouvé");
        }
    }
}

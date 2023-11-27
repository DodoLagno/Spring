package fr.diginamic.springdemo.controleurs;

import fr.diginamic.springdemo.Ville;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {

    private final List<Ville> villes = new ArrayList<>();

    // Méthode GET pour récupérer une ville par ID
    @GetMapping("/{id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable int id) {
        for (Ville ville : villes) {
            if (ville.getId() == id) {
                return new ResponseEntity<>(ville, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Ville> getVilles() {
        return villes;
    }


    // Méthode PUT pour créer une ville si l'ID est unique
    @PutMapping("/{id}")
    public ResponseEntity<Void> createOrUpdateVille(@PathVariable int id, @RequestBody Ville nouvelleVille) {
        for (Ville ville : villes) {
            if (ville.getId() == id) {
                // ID déjà existant, retourner une erreur
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        // ID unique, ajouter la nouvelle ville
        nouvelleVille.setId(id);
        villes.add(nouvelleVille);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Méthode POST pour modifier une ville par ID
    @PostMapping("/{id}")
    public ResponseEntity<Void> updateVille(@PathVariable int id, @RequestBody Ville villeModifiee) {
        for (Ville ville : villes) {
            if (ville.getId() == id) {
                // Mettre à jour les attributs de la ville
                ville.setNom(villeModifiee.getNom());
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Méthode DELETE pour supprimer une ville par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable int id) {
        Ville villeASupprimer = null;
        for (Ville ville : villes) {
            if (ville.getId() == id) {
                villeASupprimer = ville;
                break;
            }
        }
        if (villeASupprimer != null) {
            villes.remove(villeASupprimer);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

package fr.diginamic.springdemo.controleurs;

// VilleControleur.java
import fr.diginamic.springdemo.Ville;
import fr.diginamic.springdemo.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    private final VilleService villeService;

    @Autowired
    public VilleControleur(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping
    public List<Ville> getListeVilles() {
        return villeService.getListeVilles();
    }

    @PostMapping
    public ResponseEntity<String> ajouterVilles(@RequestBody List<Ville> nouvellesVilles) {
        for (Ville nouvelleVille : nouvellesVilles) {
            if (villeService.villeExisteDeja(nouvelleVille.getNom())) {
                return new ResponseEntity<>("La ville existe déjà", HttpStatus.BAD_REQUEST);
            }
            villeService.ajouterVille(nouvelleVille);
        }

        return new ResponseEntity<>("Villes insérées avec succès", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> ajouterVille(@RequestBody Ville nouvelleVille) {
        if (villeService.villeExisteDeja(nouvelleVille.getNom())) {
            return new ResponseEntity<>("La ville existe déjà", HttpStatus.BAD_REQUEST);
        }

        villeService.ajouterVille(nouvelleVille);
        return new ResponseEntity<>("Ville insérée avec succès", HttpStatus.OK);
    }
}


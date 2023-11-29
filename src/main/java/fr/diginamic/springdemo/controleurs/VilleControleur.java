package fr.diginamic.springdemo.controleurs;

import fr.diginamic.springdemo.Ville;
import fr.diginamic.springdemo.repository.VilleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    private final VilleRepository villeRepository;

    public VilleControleur(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    @GetMapping
    public List<Ville> getVilles() {
        return villeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ville getVilleById(@PathVariable Long id) {
        return villeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> createVille(@RequestBody Ville nouvelleVille) {
        if (villeRepository.existsById(nouvelleVille.getId())) {
            return new ResponseEntity<>("Une ville avec le même identifiant existe déjà.", HttpStatus.CONFLICT);
        } else {
            villeRepository.save(nouvelleVille);
            return new ResponseEntity<>("Ville créée avec succès.", HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateVille(@PathVariable Long id, @RequestBody Ville villeModifiee) {
        if (!id.equals(villeModifiee.getId())) {
            return new ResponseEntity<>("L'ID de la ville dans le chemin d'accès ne correspond pas à l'ID de la ville dans le corps de la requête.", HttpStatus.BAD_REQUEST);
        }

        Optional<Ville> villeExistante = villeRepository.findById(id);

        if (villeExistante.isPresent()) {
            Ville ville = villeExistante.get();
            updateVilleAttributes(ville, villeModifiee);
            villeRepository.save(ville);
            return new ResponseEntity<>("Ville mise à jour avec succès.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Aucune ville avec l'identifiant fourni n'a été trouvée.", HttpStatus.NOT_FOUND);
        }
    }

    private void updateVilleAttributes(Ville ville, Ville villeModifiee) {
        ville.setNom(villeModifiee.getNom());
        ville.setId(villeModifiee.getPays());
        // Mettez à jour d'autres attributs si nécessaire
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable Long id) {
        villeRepository.deleteById(id);
        // Vous pourriez également renvoyer une réponse indiquant le succès ou l'échec de l'opération
    }
}

package fr.diginamic.springdemo.controleurs;

import fr.diginamic.springdemo.Ville;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    private final List<Ville> villes = new ArrayList<>();

    @GetMapping
    public List<Ville> getVilles() {
        return villes;
    }

    @GetMapping("/{id}")
    public Ville getVilleById(@PathVariable int id) {
        return villes.stream()
                .filter(ville -> ville.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public void createVille(@RequestBody Ville nouvelleVille) {
        if (villes.stream().noneMatch(ville -> Objects.equals(ville.getId(), nouvelleVille.getId()))) {
            villes.add(nouvelleVille);
        } else {
            throw new IllegalArgumentException("Une ville avec le même identifiant existe déjà.");
            // Gérer le cas où une ville avec le même identifiant existe déjà
            // Vous pourriez lever une exception, renvoyer un code d'erreur, etc.
        }
    }

    @PutMapping("/{id}")
    public Ville updateVille(@PathVariable int id, @RequestBody Ville villeModifiee) {
        Optional<Ville> villeExistante = villes.stream()
                .filter(ville -> ville.getId() == id)
                .findFirst();

        if (villeExistante.isPresent()) {
            Ville ville = villeExistante.get();
            updateVilleAttributes(ville, villeModifiee);
            return ville;
        } else {
            // gérer le cas où aucune ville avec l'identifiant fourni n'est trouvée
            // vous pourriez lever une exception, renvoyer un code d'erreur, etc.
            return null;
        }
    }

    private void updateVilleAttributes(Ville ville, Ville villeModifiee) {
        ville.setNom(villeModifiee.getNom());
        ville.setPays(villeModifiee.getPays());
        // Mettez à jour d'autres attributs si nécessaire
    }

    @DeleteMapping("/{id}")
    public void deleteVille(@PathVariable int id) {
        villes.removeIf(ville -> ville.getId() == id);
        // Vous pourriez également renvoyer une réponse indiquant le succès ou l'échec de l'opération
    }
}

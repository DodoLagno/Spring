package fr.diginamic.springdemo.controleurs;

import fr.diginamic.springdemo.Ville;
import fr.diginamic.springdemo.repositories.VilleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    private final VilleRepository villeRepository;

    public VilleControleur(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    // Autres méthodes existantes...

    @GetMapping("/search/byName/{name}")
    public List<Ville> getVillesByName(@PathVariable String name) {
        List<Ville> villes = villeRepository.findByNomStartingWith(name);
        if (villes.isEmpty()) {
            throw new VilleNotFoundException("Aucune ville dont le nom commence par " + name + " n'a été trouvée");
        }
        return villes;
    }

    @GetMapping("/search/byPopulationGreaterThan/{min}")
    public List<Ville> getVillesByPopulationGreaterThan(@PathVariable int min) {
        List<Ville> villes = villeRepository.findByPopulationGreaterThan(min);
        if (villes.isEmpty()) {
            throw new VilleNotFoundException("Aucune ville n'a une population supérieure à " + min);
        }
        return villes;
    }

    @GetMapping("/search/byPopulationBetween/{min}/{max}")
    public List<Ville> getVillesByPopulationBetween(@PathVariable int min, @PathVariable int max) {
        List<Ville> villes = villeRepository.findByPopulationBetween(min, max);
        if (villes.isEmpty()) {
            throw new VilleNotFoundException("Aucune ville n'a une population comprise entre " + min + " et " + max);
        }
        return villes;
    }

    // Ajoutez d'autres méthodes de recherche en fonction des besoins

    // Exception personnalisée pour gérer les cas où aucune ville n'est trouvée
    public static class VilleNotFoundException extends RuntimeException {
        public VilleNotFoundException(String message) {
            super(message);
        }
    }
}

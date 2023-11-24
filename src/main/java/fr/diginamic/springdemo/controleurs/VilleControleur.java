package fr.diginamic.springdemo.controleurs;

import fr.diginamic.springdemo.Ville;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    // Autres méthodes peuvent être ajoutées ici

    @GetMapping
    public List<Ville> getListeVilles() {
        return Arrays.asList(
                new Ville("Paris", "France"),
                new Ville("New York", "États-Unis"),
                new Ville("Tokyo", "Japon")
                // Ajoutez d'autres villes si nécessaire
        );
    }
}

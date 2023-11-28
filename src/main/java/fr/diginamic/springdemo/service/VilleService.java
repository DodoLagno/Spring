package fr.diginamic.springdemo.service;

import fr.diginamic.springdemo.Ville;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VilleService {

    // Initialisation de la liste de villes avec quelques exemples
    private final List<Ville> listeVilles = new ArrayList<>(Arrays.asList(
            new Ville("Paris", "France"),
            new Ville("New York", "États-Unis"),
            new Ville("Tokyo", "Japon")
    ));

    // Retourner une copie de la liste pour éviter la modification externe
    public List<Ville> getListeVilles() {
        return new ArrayList<>(listeVilles);
    }

    // Ajouter une nouvelle ville à la liste
    public List<Ville> ajouterVille(Ville nouvelleVille) {
        if (!villeExisteDeja(nouvelleVille.getNom())) {
            listeVilles.add(nouvelleVille);
            return getListeVilles();
        } else {
            throw new IllegalArgumentException("Une ville avec le même nom existe déjà.");
        }
    }

    // Vérifier si une ville existe déjà dans la liste
    public boolean villeExisteDeja(String nomVille) {
        return listeVilles.stream().anyMatch(ville -> ville.getNom().equals(nomVille));
    }

    // Modifier une ville dans la liste
    public List<Ville> modifierVille(int idVille, Ville villeModifiee) {
        Optional<Ville> villeExistante = listeVilles.stream()
                .filter(ville -> ville.getId() == idVille)
                .findFirst();

        if (villeExistante.isPresent()) {
            Ville villeAModifier = villeExistante.get();
            villeAModifier.setNom(villeModifiee.getNom());
            villeAModifier.setPays(villeModifiee.getPays());
            return getListeVilles();
        } else {
            throw new IllegalArgumentException("Aucune ville trouvée avec l'identifiant fourni.");
        }
    }

    // Supprimer une ville de la liste
    public List<Ville> supprimerVille(int idVille) {
        listeVilles.removeIf(ville -> ville.getId() == idVille);
        return getListeVilles();
    }
}

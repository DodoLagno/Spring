package fr.diginamic.springdemo.controleurs;

import fr.diginamic.springdemo.Departement;
import fr.diginamic.springdemo.services.DepartementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementControleur {

    private final DepartementService departementService;

    public DepartementControleur(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public ResponseEntity<List<Departement>> getDepartements() {
        return departementService.extractDepartements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable int id) {
        return departementService.extractDepartement(id);
    }

    @PostMapping
    public ResponseEntity<String> insererDepartement(@RequestBody Departement nvDepartement) {
        return departementService.insertDepartement(nvDepartement);
    }

    @PostMapping("/modif/{id}")
    public ResponseEntity<String> modifierDepartementById(@PathVariable int id, @RequestBody Departement nvDepartement) {
        return departementService.modifierDepartement(id, nvDepartement);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartementById(@PathVariable int id) {
        return departementService.supprimerDepartement(id);
    }
}

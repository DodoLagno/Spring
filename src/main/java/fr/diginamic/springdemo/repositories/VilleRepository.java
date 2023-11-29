package fr.diginamic.springdemo.repositories;

import fr.diginamic.springdemo.Departement;
import fr.diginamic.springdemo.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {

    List<Ville> findByNomStartingWith(String nom);

    List<Ville> findByPopulationGreaterThan(int minPopulation);

    List<Ville> findByPopulationBetween(int minPopulation, int maxPopulation);

    List<Ville> findByDepartementAndPopulationGreaterThan(Departement departement, int population);

    List<Ville> findByDepartementAndPopulationBetween(Departement departement, int population, int population2);

    List<Ville> findTopNByDepartementOrderByPopulationDesc(Departement departement);
}

package rs.recipes.projectrecipesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.recipes.projectrecipesbackend.domain.lookup.Allergen;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Long> {
}
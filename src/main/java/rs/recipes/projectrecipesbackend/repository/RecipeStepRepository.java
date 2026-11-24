package rs.recipes.projectrecipesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.recipes.projectrecipesbackend.domain.RecipeStep;

@Repository
public interface RecipeStepRepository extends JpaRepository<RecipeStep, Long> {
}
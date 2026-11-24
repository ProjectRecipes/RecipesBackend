package rs.recipes.projectrecipesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.recipes.projectrecipesbackend.domain.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
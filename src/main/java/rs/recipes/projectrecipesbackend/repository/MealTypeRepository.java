package rs.recipes.projectrecipesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.recipes.projectrecipesbackend.domain.lookup.MealType;

@Repository
public interface MealTypeRepository extends JpaRepository<MealType, Long> {
}
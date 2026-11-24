package rs.recipes.projectrecipesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.recipes.projectrecipesbackend.domain.PantryItem;

@Repository
public interface PantryItemRepository extends JpaRepository<PantryItem, Long> {
}
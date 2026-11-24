package rs.recipes.projectrecipesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.recipes.projectrecipesbackend.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
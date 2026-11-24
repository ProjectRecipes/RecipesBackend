package rs.recipes.projectrecipesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.recipes.projectrecipesbackend.domain.CategoryProposal;

@Repository
public interface CategoryProposalRepository extends JpaRepository<CategoryProposal, Long> {
}
package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import rs.recipes.projectrecipesbackend.domain.enums.ProposalStatus;
import rs.recipes.projectrecipesbackend.domain.lookup.IngredientCategory;

import java.time.LocalDateTime;

@Entity
@Table(name = "category_proposals")
public class CategoryProposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proposer_id", nullable = false)
    private User proposer;

    @Column(nullable = false, length = 100)
    private String itemName;

    @Column(nullable = false, length = 100)
    private String proposedCategoryName;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ProposalStatus status = ProposalStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suggested_category_id")
    private IngredientCategory suggestedCategory;

    @Column(columnDefinition = "TEXT")
    private String adminResponse;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime resolvedAt;
}

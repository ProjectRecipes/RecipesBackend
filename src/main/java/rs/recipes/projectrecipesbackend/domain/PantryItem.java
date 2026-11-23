package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.*;
import rs.recipes.projectrecipesbackend.domain.enums.Measurement;

import java.time.LocalDate;

@Entity
@Table(name = "pantry_items")
public class PantryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    private String brand;

    private Double quantity;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Measurement unit;

    private LocalDate expiryDate;

    @Column(nullable = false)
    private boolean expiryNotified = false;
}

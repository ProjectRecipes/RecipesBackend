package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.*;
import rs.recipes.projectrecipesbackend.domain.enums.Measurement;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    private Double quantity;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Measurement unit;

}
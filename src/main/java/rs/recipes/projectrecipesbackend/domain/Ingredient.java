package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.*;
import rs.recipes.projectrecipesbackend.domain.enums.IngredientType;
import rs.recipes.projectrecipesbackend.domain.enums.Measurement;
import rs.recipes.projectrecipesbackend.domain.lookup.Allergen;
import rs.recipes.projectrecipesbackend.domain.lookup.IngredientCategory;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private IngredientCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Measurement unit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private IngredientType type = IngredientType.GENERIC;

    private String brand;

    @Column(length = 7)
    private String textColor;

    @ManyToMany
    @JoinTable(
            name = "ingredient_allergens",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "allergen_id")
    )
    private Set<Allergen> allergens = new HashSet<>();
}

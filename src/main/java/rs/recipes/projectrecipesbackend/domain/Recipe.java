package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import rs.recipes.projectrecipesbackend.domain.lookup.DietType;
import rs.recipes.projectrecipesbackend.domain.lookup.DishType;
import rs.recipes.projectrecipesbackend.domain.lookup.MealType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "meal_type_id", nullable = false)
    private MealType mealType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dish_type_id", nullable = false)
    private DishType dishType;

    @ManyToMany
    @JoinTable(
            name = "recipe_diet_types",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "diet_type_id"))
    private Set<DietType> dietTypes = new HashSet<>();

    @Column(nullable = false)
    private Integer servings;

    @Column(nullable = false)
    private Integer prepTimeMinutes;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "main_image_id")
    private Image mainImage;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "recipe_images",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private List<Image> images = new ArrayList<>();

    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String story;

    private String authorRegion;

    @Embedded
    private Origin origin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_recipe_id")
    private Recipe originalRecipe;

    @Column(columnDefinition = "TEXT")
    private String modificationNote;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("stepOrder ASC")
    private List<RecipeStep> steps = new ArrayList<>();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.*;
import rs.recipes.projectrecipesbackend.domain.enums.PreparationType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe_steps")
public class RecipeStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @Column(nullable = false)
    private Integer stepOrder;

    @Column(length = 150)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PreparationType preparationType;

    private Integer durationMinutes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "recipe_step_images",
            joinColumns = @JoinColumn(name = "step_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private List<Image> images = new ArrayList<>();
}

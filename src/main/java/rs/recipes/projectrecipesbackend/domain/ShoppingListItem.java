package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.*;
import rs.recipes.projectrecipesbackend.domain.enums.Measurement;

@Entity
@Table(name = "shopping_list_items")
public class ShoppingListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shopping_list_id", nullable = false)
    private ShoppingList shoppingList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    private Double quantity;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Measurement unit;

    @Column(nullable = false)
    private boolean purchased = false;
}

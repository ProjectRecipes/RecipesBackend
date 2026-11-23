package rs.recipes.projectrecipesbackend.domain.lookup;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingredient_categories")
public class IngredientCategory extends LookupEntity { }
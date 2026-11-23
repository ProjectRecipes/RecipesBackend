package rs.recipes.projectrecipesbackend.domain.lookup;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "meal_types")
public class MealType extends LookupEntity { }
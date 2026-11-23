package rs.recipes.projectrecipesbackend.domain.lookup;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dish_types")
public class DishType extends LookupEntity { }
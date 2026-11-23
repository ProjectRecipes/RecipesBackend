package rs.recipes.projectrecipesbackend.domain.lookup;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "allergens")
public class Allergen extends LookupEntity { }

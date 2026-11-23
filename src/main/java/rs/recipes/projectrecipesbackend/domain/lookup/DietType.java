package rs.recipes.projectrecipesbackend.domain.lookup;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "diet_types")
public class DietType extends LookupEntity { }

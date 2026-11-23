package rs.recipes.projectrecipesbackend.domain.lookup;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class LookupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;
}
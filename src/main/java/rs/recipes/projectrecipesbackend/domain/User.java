package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import rs.recipes.projectrecipesbackend.domain.enums.Role;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role = Role.USER;

    @Column(nullable = false)
    private boolean enabled = false;

    private String profileImage;

    private String region;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @ManyToMany
    @JoinTable(
            name = "favorite_recipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Recipe> favoriteRecipes = new HashSet<>();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


}

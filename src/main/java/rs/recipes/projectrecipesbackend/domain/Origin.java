package rs.recipes.projectrecipesbackend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Origin {

    @Column(name = "origin_country")
    private String country;

    @Column(name = "origin_region")
    private String region;

    @Column(name = "origin_city")
    private String city;

    @Column(name = "origin_latitude")
    private Double latitude;

    @Column(name = "origin_longitude")
    private Double longitude;
}
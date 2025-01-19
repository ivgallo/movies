package org.example.movies.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors;

    public void addActor(Actor actor) {

        if (this.actors == null) {
            this.actors = new HashSet<>();
        }

        this.actors.add(actor);

    }

}
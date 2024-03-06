package org.example.movies.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FilmResponse {

    private Long id;
    private String title;
    private Set<ActorModel> actors;
}

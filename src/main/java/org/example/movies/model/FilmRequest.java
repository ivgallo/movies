package org.example.movies.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class FilmRequest {

    private String title;
    private Set<ActorModel> actors;

}

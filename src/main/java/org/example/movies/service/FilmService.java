package org.example.movies.service;

import org.example.movies.domain.Film;
import org.example.movies.model.FilmRequest;
import org.example.movies.model.FilmResponse;

import java.util.List;

public interface FilmService {

    Film createFilm(FilmRequest filmRequest);
    FilmResponse getFilm(Long id);
    List<FilmResponse> getAllFilm();


}

package org.example.movies.controller;

import org.example.movies.domain.Film;
import org.example.movies.model.FilmRequest;
import org.example.movies.model.FilmResponse;
import org.example.movies.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/film")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<FilmResponse>> getAllFilm() {
        return ResponseEntity.ok(filmService.getAllFilm());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmResponse> getFilm(@PathVariable Long id) {
        return ResponseEntity.ok(
                filmService.getFilm(id)
        );
    }

    @PostMapping
    public ResponseEntity<Void> createFilm(@RequestBody FilmRequest filmRequest) {
        Film savedFilm = filmService.createFilm(filmRequest);
        URI locationOfNewMovie = UriComponentsBuilder.newInstance()
                .path("api/film/{id}")
                .buildAndExpand(savedFilm.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewMovie).build();
    }


}

package org.example.movies.service;

import org.example.movies.domain.Film;
import org.example.movies.mapper.FilmMapper;
import org.example.movies.model.FilmRequest;
import org.example.movies.model.FilmResponse;
import org.example.movies.repository.FilmRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class FilmServiceImpl implements FilmService{

    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    public FilmServiceImpl(FilmRepository repository, FilmMapper filmMapper) {
        this.filmRepository = repository;
        this.filmMapper = filmMapper;
    }

    @Override
    public Film createFilm(FilmRequest filmRequest) {
        Film filmToSave = filmMapper.toFilm(filmRequest);
        return filmRepository.save(filmToSave);
    }

    @Override
    public FilmResponse getFilm(Long id) {

        Film film  = filmRepository.findById( id ).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The film id " + id + " does not exist"));

        return filmMapper.toFilmResponse(film);
    }

    @Override
    public List<FilmResponse> getAllFilm() {
        return StreamSupport.stream(filmRepository.findAll().spliterator(), false)
                .map(filmMapper::toFilmResponse)
                .toList();

    }
}

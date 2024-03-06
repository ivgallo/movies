package org.example.movies.mapper;

import org.example.movies.domain.Film;
import org.example.movies.model.FilmRequest;
import org.example.movies.model.FilmResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    @Mapping(target = "id", ignore = true)
    Film toFilm(FilmRequest filmRequest);
    FilmResponse toFilmResponse(Film film);

}

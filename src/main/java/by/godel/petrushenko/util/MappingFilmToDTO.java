package by.godel.petrushenko.util;


import by.godel.petrushenko.dto.FilmDto;
import by.godel.petrushenko.entity.Film;
import org.springframework.stereotype.Service;

@Service
public class MappingFilmToDTO {
    public FilmDto filmToDTO(Film film) {
        FilmDto dto = new FilmDto();

        dto.setDirectorFirstName(film.getDirector().getFirstName());
        dto.setDirectorLastName(film.getDirector().getLastName());
        dto.setDirectorBirthDate(film.getDirector().getBirthDate());
        dto.setFilmName(film.getName());
        dto.setFilmReleaseDate(film.getReleaseDate());
        dto.setFilmGenre(film.getGenre());

        return dto;
    }
}

package by.godel.petrushenko.service;


import by.godel.petrushenko.dto.FilmDto;
import by.godel.petrushenko.entity.Director;
import by.godel.petrushenko.entity.Film;
import by.godel.petrushenko.repo.DirectorRepo;
import by.godel.petrushenko.repo.FilmRepo;
import by.godel.petrushenko.util.MappingFilmToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmSearch {
    @Autowired
    FilmRepo filmRepo;
    @Autowired
    DirectorRepo directorRepo;
    @Autowired
    MappingFilmToDTO mappingFilmToDTO;

    public List<Film> getFilteredFilms(
            String lastName,
            Date afterDate,
            Date beforeDate) {

        if (lastName == null) lastName = "";
        if (beforeDate == null) beforeDate = new Date(new java.util.Date().getTime());
        if (afterDate == null) afterDate = Date.valueOf("1895-01-01");
        if (!lastName.equals("")) {
            Director director = directorRepo.findByLastNameIsLike(lastName + "%").get(0);
            return filmRepo.findByDirectorAndReleaseDateBetween(director, afterDate, beforeDate);
        } else return filmRepo.findByReleaseDateBetween(afterDate, beforeDate);

    }

    public List<FilmDto> getFilteredFilmDtos(String lastName,
                                             Date afterDate,
                                             Date beforeDate) {
        return getFilteredFilms(lastName, afterDate, beforeDate).stream()
                .map(mappingFilmToDTO::filmToDTO)
                .collect(Collectors.toList());
    }


}

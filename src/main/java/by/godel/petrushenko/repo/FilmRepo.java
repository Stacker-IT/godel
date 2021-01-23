package by.godel.petrushenko.repo;

import by.godel.petrushenko.entity.Director;
import by.godel.petrushenko.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface FilmRepo extends JpaRepository<Film, Long> {
    Film findByName(String name);
    List<Film> findByDirectorAndReleaseDateBetween(Director director, Date dateAfter, Date dateBefore);
    List<Film> findByReleaseDateBetween(Date dateAfter, Date dateBefore);


}

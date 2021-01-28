package by.godel.petrushenko.controller;

import by.godel.petrushenko.entity.Director;
import by.godel.petrushenko.entity.Film;
import by.godel.petrushenko.repo.DirectorRepo;
import by.godel.petrushenko.repo.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class InitController {
    @Autowired
    DirectorRepo directorRepo;
    @Autowired
    FilmRepo filmRepo;

    @GetMapping("/init")
    public String init(Map<String, Object> model) {
        List<Director> directors = directorRepo.findByLastNameIsLike("Spie%");
        if (!directors.isEmpty()) return "redirect:/";
        Director director = new Director("Steven", "Spielberg", Date.valueOf("1946-12-18"));
        directorRepo.save(director);
        filmRepo.save(new Film("The Last Gun", Date.valueOf("1959-01-01"), "Drama", director));
        filmRepo.save(new Film("Fighter Squad", Date.valueOf("1961-01-01"), "Drama", director));
        filmRepo.save(new Film("Escape to Nowhere", Date.valueOf("1961-01-01"), "Drama", director));
        filmRepo.save(new Film("Firelight", Date.valueOf("1964-01-01"), "Horror", director));

        Director director1 = new Director("Vladimir", "Petrushenko", Date.valueOf("1991-12-10"));
        directorRepo.save(director1);

        Director director2 = new Director("Christopher", "Nolan", Date.valueOf("1970-07-30"));
        directorRepo.save(director2);
        filmRepo.save(new Film("Following", Date.valueOf("1998-01-01"), "Drama", director2));

        Director director3 = new Director("Alfred", "Hitchcock", Date.valueOf("1899-08-13"));
        directorRepo.save(director3);
        filmRepo.save(new Film("The Great Day", Date.valueOf("1920-01-01"), "Horror", director3));
        filmRepo.save(new Film("The Call of Youth", Date.valueOf("1921-01-01"), "Horror", director3));
        filmRepo.save(new Film("Three Live Ghosts", Date.valueOf("1922-01-01"), "Horror", director3));
        filmRepo.save(new Film("Number 13", Date.valueOf("1923-01-01"), "Horror", director3));
        filmRepo.save(new Film("Always Tell Your Wife", Date.valueOf("1924-01-01"), "Horror", director3));
        filmRepo.save(new Film("The Blackguard", Date.valueOf("1925-01-01"), "Horror", director3));


        return "redirect:/";
    }
}

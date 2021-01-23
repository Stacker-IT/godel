package by.godel.petrushenko.controller;

import by.godel.petrushenko.entity.Director;
import by.godel.petrushenko.repo.DirectorRepo;
import by.godel.petrushenko.repo.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private DirectorRepo directorRepo;

    @Autowired
    private FilmRepo filmRepo;

    @GetMapping("/")
    public String directors(
            @RequestParam(required = false, defaultValue = "") String lastName,
            @RequestParam(required = false, defaultValue = "1895-01-01") Date afterDate,
            @RequestParam(required = false) Date beforeDate,
            Map<String, Object> model) {

        Date currentDate = new Date(new java.util.Date().getTime());
        if (beforeDate == null) beforeDate = currentDate;
        if (!lastName.equals("")) {
            Director director = directorRepo.findByLastNameIsLike(lastName + "%");
            model.put("films", filmRepo.findByDirectorAndReleaseDateBetween(director, afterDate, beforeDate));
        } else model.put("films", filmRepo.findByReleaseDateBetween(afterDate, beforeDate));

        model.put("dateAfter", afterDate.toString());
        model.put("dateBefore", beforeDate.toString());
        model.put("lastName", lastName);
        return "directors";
    }


}

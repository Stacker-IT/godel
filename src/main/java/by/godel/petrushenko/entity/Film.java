package by.godel.petrushenko.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date releaseDate;
    private String genre;
    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    public Film(String name, Date releaseDate, String genre, Director director) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.director = director;
    }
}

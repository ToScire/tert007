package entity.film;

import java.sql.Date;

/**
 * Created by Alexander on 02.04.2016.
 */
public class Film {
    private int id;
    private String title;
    private FilmGenre genre;
    private String director;
    private String description;
    private Date date;

    public Film(){
    }

    public Film(int id, String title, FilmGenre genre, String director, String description, Date date) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FilmGenre getGenre() {
        return genre;
    }

    public void setGenre(FilmGenre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

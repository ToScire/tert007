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

    public int getAgeLimitationId() {
        return ageLimitationId;
    }

    public void setAgeLimitationId(int ageLimitationId) {
        this.ageLimitationId = ageLimitationId;
    }

    private int ageLimitationId;

    private Date date;

    public Film() {
    }

    public Film(int id, String title, FilmGenre genre, String director, String description, Date date) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.description = description;
        this.date = date;
    }

    public String[] getValues() {
        String[] result = new String[7];
        result[0] = String.valueOf(id);
        result[1] = String.valueOf(ageLimitationId);
        result[2] = title;
        result[3] = genre.toString();
        result[4] = director;
        result[5] = date.toString();
        result[6] = description;
        return result;
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

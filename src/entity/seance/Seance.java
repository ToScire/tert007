package entity.seance;

import entity.film.Film;
import entity.hall.Hall;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Alexander on 02.04.2016.
 */
public class Seance {
    private int id;
    private Hall hall;
    private Film film;
    private Date date;
    private Time time;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

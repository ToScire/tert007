package entity.ticket;

import entity.film.Film;
import entity.hall.Hall;

import java.sql.Date;

/**
 * Created by Alexander on 02.04.2016.
 */
public class Ticket {
    private int id;
    private Film film;
    private Hall hall;
    private int price;
    private Date date;
    private Date time;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    private int place;

    public Ticket(){

    }

    public Ticket(int id, int place, Film film, Hall hall, int price, Date date, Date time) {
        this.id = id;
        this.place = place;
        this.film = film;
        this.hall = hall;
        this.price = price;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public Hall getHall() {
        return hall;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public Date getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

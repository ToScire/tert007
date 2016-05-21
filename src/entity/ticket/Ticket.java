package entity.ticket;

import entity.film.Film;
import entity.hall.Hall;
import entity.seance.Seance;
import entity.user.User;

import java.util.Date;

/**
 * Created by Alexander on 02.04.2016.
 */
public class Ticket {
    private int id;
    private Seance seance;
    private User user;
    private int place;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seance getSeance() {
        return seance;
    }

    public int getPrice() {
        return seance.getPrice();
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Hall getHall() {
        return seance.getHall();
    }

    public Film getFilm() {
        return seance.getFilm();
    }

    public String getDateBySting() {
        return seance.getDateByString();
    }

    public String getTimeByString() {
        return seance.getTimeByString();
    }

}

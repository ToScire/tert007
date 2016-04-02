package entity.seance;

import entity.film.Film;
import entity.hall.Hall;

import java.sql.Date;

/**
 * Created by Alexander on 02.04.2016.
 */
public class Seance {
    private int id;
    private Hall hall;
    private Film film;
    private Date date;
    private Date time;
}

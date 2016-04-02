package dao;

import entity.film.Film;

import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public interface FilmDao {
    Film findFilmByTitle() throws DaoException;
    List<Film> getFilmsCollections() throws DaoException;
}

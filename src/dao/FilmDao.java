package dao;

import entity.film.Film;

import java.sql.Date;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public interface FilmDao{
    Film findFilmByTitle(String title) throws DaoException;
    Film findFilmById(int id) throws DaoException;
    List<Film> findFilmsByDate(Date date) throws DaoException;
    List<Film> getFilmsCollections() throws DaoException;
    boolean insertNewFilm(Film film) throws DaoException;
    boolean deleteFilmById(int id) throws DaoException;
    boolean updateFilm(int id,Film newFilm) throws DaoException;
}

package dao;

import entity.film.Film;
import entity.seance.Seance;

import java.sql.Date;
import java.util.List;

/**
 * Created by Alexander on 30.04.2016.
 */
public interface SeanceDao {
    Seance findSeanceById(int id) throws DaoException;
    List<Seance> findSeancesByDate(Date date) throws DaoException;
    List<Seance> getSeancesCollection(Date startDate, Date finishDate) throws DaoException;

    boolean addNewSeance(Seance seance) throws DaoException;
    boolean removeSeanceById(int id) throws DaoException;
    boolean updateSeance(int id, Seance newSeance) throws DaoException;
}

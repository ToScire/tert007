package dao.databaseimpl;

import dao.DaoException;
import dao.SeanceDao;
import entity.seance.Seance;

import java.sql.Date;
import java.util.List;

/**
 * Created by Alexander on 30.04.2016.
 */
public class SeanceDatabaseDao implements SeanceDao {
    @Override
    public Seance findSeanceById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Seance> findSeancesByDate(Date date) throws DaoException {
        return null;
    }

    @Override
    public List<Seance> getSeancesCollection(Date startDate, Date finishDate) throws DaoException {
        return null;
    }

    @Override
    public boolean addNewSeance(Seance seance) throws DaoException {
        return false;
    }

    @Override
    public boolean removeSeanceById(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean updateSeance(int id, Seance seance) throws DaoException {
        return false;
    }
}

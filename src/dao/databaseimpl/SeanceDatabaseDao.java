package dao.databaseimpl;

import dao.DaoException;
import dao.SeanceDao;
import entity.film.Film;
import entity.hall.Hall;
import entity.seance.Seance;

import java.net.FileNameMap;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 30.04.2016.
 */
public class SeanceDatabaseDao extends Connector implements SeanceDao {

    private static final String tableName = "seance";

    private static final String columnId = "id";
    private static final String columnHallId = "id_hall";
    private static final String columnFilmId = "id_film";
    private static final String columnDate = "date";
    private static final String columnTime = "time";
    private static final String columnPrice = "price";


    private static final String[] columnsName = {
            columnId,
            columnHallId,
            columnFilmId,
            columnDate,
            columnTime,
            columnPrice
    };

    private SeanceDatabaseDao(){
        super();
    }

    private static final SeanceDatabaseDao instance = new SeanceDatabaseDao();

    public static SeanceDatabaseDao getInstance() {
        return instance;
    }

    private static String[] getValues(Seance seance) {
        String[] result = {
                String.valueOf(seance.getId()),
                String.valueOf(seance.getHall().getId()),
                String.valueOf(seance.getFilm().getId()),
                String.valueOf(seance.getDate()),
                String.valueOf(seance.getTime()),
                String.valueOf(seance.getPrice())
        };

        return result;
    }

    @Override
    public Seance findSeanceById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(tableName, columnsName, columnId + "='" + id + "'");

            resultSet.next();
            return createSeanceFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Seance> findSeancesByDate(Date date) throws DaoException {
        ResultSet resultSet = null;
        try {

            resultSet = databaseController.select(tableName, columnsName, columnDate + "='" + date + "'");

            return createSeanceCollectionFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Seance> getSeancesCollection(Date startDate, Date finishDate) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(tableName, columnsName, columnDate + " BETWEEN '"+ startDate + "' AND '" + finishDate +"'");

            return createSeanceCollectionFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean addNewSeance(Seance seance) throws DaoException {
        try {
            return databaseController.insert(tableName, columnsName, getValues(seance));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean removeSeanceById(int id) throws DaoException {
        try {
            return databaseController.remove(tableName, columnId + "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updateSeance(Seance newSeance) throws DaoException {
        try {
            return databaseController.update(tableName, columnsName, getValues(newSeance), columnId + "=" + newSeance.getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private List<Seance> createSeanceCollectionFromResultSet(ResultSet resultSet) throws DaoException {
        List<Seance> result = new ArrayList<>();
        try {
            while (resultSet.next()) {
                result.add(createSeanceFromResultSet(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Seance createSeanceFromResultSet(ResultSet resultSet) throws DaoException {
        Seance seance = new Seance();

        try {
            seance.setId(resultSet.getInt(columnId));
            seance.setDate(resultSet.getDate(columnDate));
            seance.setTime(resultSet.getTime(columnTime));
            seance.setPrice(resultSet.getInt(columnPrice));

            int hallId = resultSet.getInt(columnHallId);
            Hall hall = HallDatabaseDao.getInstance().findHallById(hallId);
            seance.setHall(hall);

            int filmId = resultSet.getInt(columnFilmId);
            Film film = FilmDatabaseDao.getInstance().findFilmById(filmId);
            seance.setFilm(film);

            return seance;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}

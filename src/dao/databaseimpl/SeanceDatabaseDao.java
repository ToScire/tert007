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

    private static final String[] columnsName = {
            columnId,
            columnHallId,
            columnFilmId,
            columnDate,
            columnTime
    };

    private SeanceDatabaseDao(){
        super();
    }

    private static final SeanceDatabaseDao instance = new SeanceDatabaseDao();


    public static SeanceDatabaseDao getInstance() {
        return instance;
    }

    @Override
    public Seance findSeanceById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(tableName, columnsName, null);

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
        return null;
    }

    @Override
    public boolean addNewSeance(Seance seance) throws DaoException {

        /*try {
            //return databaseController.insert(tableName, columnsName, seance.getValues());
            return true;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        */
        return true;
    }

    @Override
    public boolean removeSeanceById(int id) throws DaoException {
        return false;
    }

    @Override
    public boolean updateSeance(int id, Seance seance) throws DaoException {
        return false;
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

        //Statement filmGenreStatement = null;
        //ResultSet filmGenreResultSet = null;
        //DatabaseController databaseControllerForGenreTable = null;


        try {
            seance.setId(resultSet.getInt(columnId));
            seance.setDate(resultSet.getDate(columnDate));
            seance.setTime(resultSet.getDate(columnTime));


            //Hall hall = new Hall();

            int filmId = resultSet.getInt(columnFilmId);

            Film film = FilmDatabaseDao.getInstance().findFilmById(filmId);
            seance.setFilm(film);

            /*
            filmGenreStatement = connection.createStatement();
            databaseControllerForGenreTable = new DatabaseController(filmGenreStatement);
            filmGenreResultSet = databaseControllerForGenreTable.select(film_genre_table, film_genre_value, film_genre_id + "='" +  filmId +"'");

            if (filmGenreResultSet.next()) {
                String filmGenre = filmGenreResultSet.getString(film_genre_value);
                film.setGenre(filmGenre);
            }
*/
            return seance;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
/*
            try {
                closeResultSet(filmGenreResultSet);
                closeStatement(filmGenreStatement);
            } catch (SQLException e){
                throw new DaoException(e);
            }
*/
        }
    }
}

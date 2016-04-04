package dao.databaseimpl;

import dao.DaoException;
import dao.FilmDao;
import entity.film.Film;
import entity.film.FilmGenre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public class FilmDatabaseDao extends Connector implements FilmDao {
    private final String AllFromFilmsQuery = "SELECT * FROM " + FilmDatabaseDao.tableName;
    public static final String tableName = "film";
    public static final String columnId = "id";
    public static final String columnTitle = "title";
    public static final String columnDescription = "description";
    public static final String columnDirector = "director";
    public static final String columnGenre = "genre";
    public static final String columnDate = "date";

    private static FilmDatabaseDao instance = new FilmDatabaseDao();

    private FilmDatabaseDao() {
        super();
    }

    public static FilmDatabaseDao getInstance(){
        return instance;
    }

    public static String[] getColumnNames(){
        String[] result = new String[6];
        result[0] = FilmDatabaseDao.columnId;
        result[1] = FilmDatabaseDao.columnTitle;
        result[2] = FilmDatabaseDao.columnDescription;
        result[3] = FilmDatabaseDao.columnDirector;
        result[4] = FilmDatabaseDao.columnGenre;
        result[5] = FilmDatabaseDao.columnDate;
        return  result;
    }

    @Override
    public Film findFilmByTitle(String title) throws DaoException{
        ResultSet resultSet = null;
        try {
            resultSet = dbController.select(FilmDatabaseDao.tableName, FilmDatabaseDao.getColumnNames(),FilmDatabaseDao.columnTitle + "='"
                    + title + "'");
            return setToFilm(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Film findFilmById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = dbController.select(FilmDatabaseDao.tableName,FilmDatabaseDao.getColumnNames(),FilmDatabaseDao.columnId + "='"
            + id + "'");
            return setToFilm(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Film> findFilmsByDate(Date date) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = dbController.select(FilmDatabaseDao.tableName,FilmDatabaseDao.getColumnNames(),FilmDatabaseDao.columnDate + "='" +
            date + "'");
            return filmsToCollection(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Film> getFilmsCollections() throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = dbController.select(tableName,FilmDatabaseDao.getColumnNames(),null);
            return filmsToCollection(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean insertNewFilm(Film film) throws DaoException {
        try {
            return dbController.insert(tableName,FilmDatabaseDao.getColumnNames(),film.getValues());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean removeFilmById(int id) throws DaoException {
        try {
            return dbController.remove(tableName,FilmDatabaseDao.columnId + "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updateFilm(int id, Film newFilm) throws DaoException {
        try {
            return dbController.update(tableName,FilmDatabaseDao.getColumnNames(),newFilm.getValues(),FilmDatabaseDao.columnId + "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private List<Film> filmsToCollection(ResultSet filmsSet) throws  DaoException{
        List<Film> result = new ArrayList<Film>();
        try {
            while (filmsSet.next()) {
                result.add(this.setToFilm(filmsSet));
            }
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Film setToFilm(ResultSet film) throws  DaoException{
        Film result = new Film();
        try {
            result.setId(film.getInt(FilmDatabaseDao.columnId));
            result.setTitle(film.getString(FilmDatabaseDao.columnTitle));
            result.setDescription(film.getString(FilmDatabaseDao.columnDescription));
            result.setDirector(film.getString(FilmDatabaseDao.columnDirector));
            result.setGenre(FilmGenre.valueOf(film.getString(FilmDatabaseDao.columnGenre)));
            result.setDate(film.getDate(FilmDatabaseDao.columnDate));
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}

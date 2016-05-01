package dao.databaseimpl;

import dao.DaoException;
import dao.FilmDao;
import entity.film.Film;
import entity.film.FilmGenreHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public class FilmDatabaseDao extends Connector implements FilmDao {

    private static final String tableName = "film";

    private static final String columnId = "id";
    private static final String columnLimitationId = "age_limitation_id";
    private static final String columnTitle = "title";
    private static final String columnDescription = "description";
    private static final String columnDirector = "director";
    private static final String columnGenreId = "film_genre_id";
    private static final String columnDate = "date";

    private static final String film_genre_table = "film_genre";
    private static final String film_genre_id = "id";
    private static final String film_genre_value = "film_genre_value";

    private static final String[] columnsName = {
            columnId,
            columnLimitationId,
            columnTitle,
            columnGenreId,
            columnDirector,
            columnDate,
            columnDescription
    };

    private static FilmDatabaseDao instance = new FilmDatabaseDao();

    private FilmDatabaseDao() {
        super();
    }

    public static FilmDatabaseDao getInstance(){
        return instance;
    }

    @Override
    public List<Film> findFilmsByTitle(String title) throws DaoException{
        ResultSet resultSet = null;
        try {

            resultSet = databaseController.select(FilmDatabaseDao.tableName, columnsName, columnTitle + "='"
                    + title + "'");

            return createFilmsCollectionFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Film findFilmById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(FilmDatabaseDao.tableName, columnsName, columnId + "='"
                    + id + "'");

            if (resultSet.next()) {
                return createFilmFromResultSet(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Film> findFilmsByDate(Date date) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(FilmDatabaseDao.tableName, columnsName, columnDate + "='" +
                    date + "'");
            return createFilmsCollectionFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Film> getFilmsCollection() throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(tableName, columnsName, null);
            return createFilmsCollectionFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean addNewFilm(Film film) throws DaoException {
        try {
            return databaseController.insert(tableName, columnsName, film.getValues());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean removeFilmById(int id) throws DaoException {
        try {
            return databaseController.remove(tableName, columnId + "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updateFilm(int id, Film newFilm) throws DaoException {
        try {
            return databaseController.update(tableName, columnsName, newFilm.getValues(), columnId + "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private List<Film> createFilmsCollectionFromResultSet(ResultSet resultSet) throws  DaoException{
        List<Film> result = new ArrayList<Film>();
        try {
            while (resultSet.next()) {
                result.add(createFilmFromResultSet(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Film createFilmFromResultSet(ResultSet resultSet) throws  DaoException {

        Film film = new Film();

        Statement filmGenreStatement = null;
        ResultSet filmGenreResultSet = null;
        DatabaseController databaseControllerForGenreTable = null;

        try {
            film.setId(resultSet.getInt(columnId));
            film.setAgeLimitationId(resultSet.getInt(columnLimitationId));
            film.setTitle(resultSet.getString(columnTitle));
            film.setDescription(resultSet.getString(columnDescription));
            film.setDirector(resultSet.getString(columnDirector));
            film.setDate(resultSet.getDate(columnDate));

            int genreId = resultSet.getInt(columnGenreId);

            filmGenreStatement = connection.createStatement();
            databaseControllerForGenreTable = new DatabaseController(filmGenreStatement);
            filmGenreResultSet = databaseControllerForGenreTable.select(film_genre_table, film_genre_value, film_genre_id + "='" +  genreId +"'");

            if (filmGenreResultSet.next()) {
                int filmGenre = genreId;
                film.setGenre(filmGenre);
            }

            return film;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {

            try {
                closeResultSet(filmGenreResultSet);
                closeStatement(filmGenreStatement);
            } catch (SQLException e){
                throw new DaoException(e);
            }

        }
    }

}

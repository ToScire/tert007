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
    private static final String film_genre_value = "value";


    private static final String[] columnsName = {
            FilmDatabaseDao.columnId,
            FilmDatabaseDao.columnLimitationId,
            FilmDatabaseDao.columnTitle,
            FilmDatabaseDao.columnGenreId,
            FilmDatabaseDao.columnDirector,
            FilmDatabaseDao.columnDate,
            FilmDatabaseDao.columnDescription
    };

    private static FilmDatabaseDao instance = new FilmDatabaseDao();

    private FilmDatabaseDao() {
        super();
    }

    public static FilmDatabaseDao getInstance(){
        return instance;
    }

    @Override
    public Film findFilmByTitle(String title) throws DaoException{
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(FilmDatabaseDao.tableName, columnsName,FilmDatabaseDao.columnTitle + "='"
                    + title + "'");
            return createFilmFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Film findFilmById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(FilmDatabaseDao.tableName, columnsName,FilmDatabaseDao.columnId + "='"
                    + id + "'");
            return createFilmFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Film> findFilmsByDate(Date date) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(FilmDatabaseDao.tableName, columnsName,FilmDatabaseDao.columnDate + "='" +
                    date + "'");
            return createFilmsCollectionFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Film> getFilmsCollections() throws DaoException {
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
            return databaseController.remove(tableName,FilmDatabaseDao.columnId + "=" + id);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updateFilm(int id, Film newFilm) throws DaoException {
        try {
            return databaseController.update(tableName, columnsName,newFilm.getValues(),FilmDatabaseDao.columnId + "=" + id);
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

    private Film createFilmFromResultSet(ResultSet resultSet) throws  DaoException{

        Film film = new Film();

        Statement filmGenreStatement = null;
        DatabaseController databaseControllerForGenreTable = null;
        ResultSet filmGenreResultSet = null;

        try {
            film.setId(resultSet.getInt(FilmDatabaseDao.columnId));
            film.setAgeLimitationId(resultSet.getInt(FilmDatabaseDao.columnLimitationId));
            film.setTitle(resultSet.getString(FilmDatabaseDao.columnTitle));
            film.setDescription(resultSet.getString(FilmDatabaseDao.columnDescription));
            film.setDirector(resultSet.getString(FilmDatabaseDao.columnDirector));
            film.setDate(resultSet.getDate(FilmDatabaseDao.columnDate));

            int genreId = resultSet.getInt(columnGenreId);

            filmGenreStatement = connection.createStatement();
            databaseControllerForGenreTable = new DatabaseController(filmGenreStatement);
            filmGenreResultSet = databaseControllerForGenreTable.select(film_genre_table, film_genre_value, film_genre_id + "='" +  genreId +"'");

            if (filmGenreResultSet.next()) {
                FilmGenre filmGenre = FilmGenre.valueOf(filmGenreResultSet.getString(film_genre_value));
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

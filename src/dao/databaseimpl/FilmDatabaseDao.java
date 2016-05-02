package dao.databaseimpl;

import dao.DaoException;
import dao.FilmDao;
import dao.factoryimpl.DatabaseDaoFactory;
import entity.film.AgeLimitation;
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

    private static final String[] columnsName = {
            columnId,
            columnLimitationId,
            columnTitle,
            columnGenreId,
            columnDirector,
            columnDate,
            columnDescription
    };

    private static final String[] getValues(Film film) throws DaoException{

        int filmGenreId = FilmGenreDatabaseDao.getInstance().findIdByFilmGenreValue(film.getGenre());
        int ageLimitationId = AgeLimitationDatabaseDao.getInstance().findIdByAgeLimitationValue(film.getAgeLimitation());

        String[] result = {
            String.valueOf(film.getId()),
            String.valueOf(ageLimitationId),
            film.getTitle(),
            String.valueOf(filmGenreId),
            film.getDirector(),
            film.getDate().toString(),
            film.getDescription()
        };

        return result;
    }

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
            resultSet = databaseController.select(FilmDatabaseDao.tableName, columnsName, columnTitle + "='" + title + "'");

            return createFilmsCollectionFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Film findFilmById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(tableName, columnsName, columnId + "='" + id + "'");

            resultSet.next();
            return createFilmFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Film> findFilmsByDate(Date date) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = databaseController.select(tableName, columnsName, columnDate + "='" + date + "'");
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
            return databaseController.insert(tableName, columnsName, getValues(film));
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
    public boolean updateFilm(Film newFilm) throws DaoException {
        try {
            return databaseController.update(tableName, columnsName, getValues(newFilm), columnId + "=" + newFilm.getId());
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

        try {
            film.setId(resultSet.getInt(columnId));
            film.setTitle(resultSet.getString(columnTitle));
            film.setDescription(resultSet.getString(columnDescription));
            film.setDirector(resultSet.getString(columnDirector));
            film.setDate(resultSet.getDate(columnDate));

            int ageLimitationId = resultSet.getInt(columnLimitationId);
            AgeLimitation ageLimitation = AgeLimitationDatabaseDao.getInstance().findAgeLimitationById(ageLimitationId);
            film.setAgeLimitation(ageLimitation);

            int genreId = resultSet.getInt(columnGenreId);
            FilmGenre filmGenre = FilmGenreDatabaseDao.getInstance().findFilmGenreById(genreId);
            film.setGenre(filmGenre);

            return film;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}

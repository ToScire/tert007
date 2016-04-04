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
    public static final String tableName = "films";
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

    public static String getColumnNames(){
        return FilmDatabaseDao.columnId + "," +FilmDatabaseDao.columnTitle + ","
                + FilmDatabaseDao.columnDescription + "," + FilmDatabaseDao.columnDirector + "," + FilmDatabaseDao.columnGenre
                + "," + FilmDatabaseDao.columnDate;
    }

    @Override
    public Film findFilmByTitle(String title) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(AllFromFilmsQuery +
                    " WHERE " + FilmDatabaseDao.columnTitle + "='" + title + "'" );
            return this.setToFilm(resultSet);
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            try {
                closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public Film findFilmById(int id) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(AllFromFilmsQuery +
                    " WHERE " + FilmDatabaseDao.columnId + "='" + id + "'" );
            return this.setToFilm(resultSet);
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            try {
                closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public List<Film> findFilmsByDate(Date date) throws DaoException {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(AllFromFilmsQuery +
                    " WHERE " + FilmDatabaseDao.columnDate + "='" + date + "'" );
            return this.filmsToCollection(resultSet);
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            try {
                closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public List<Film> getFilmsCollections() throws DaoException {
        List<Film> films = new ArrayList<Film>();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(AllFromFilmsQuery);
            return this.filmsToCollection(resultSet);
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            try {
                closeResultSet(resultSet);
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public boolean insertNewFilm(Film film) throws DaoException {
        try{
            String query = "INSERT INTO "+ FilmDatabaseDao.tableName + "(" + FilmDatabaseDao.getColumnNames() + ") VALUES (" + film.getValues() + ")";
            return statement.execute(query);
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
    }

    @Override
    public boolean deleteFilmById(int id) throws DaoException {
        try{
            String query = "DELETE FROM " + FilmDatabaseDao.tableName + " WHERE " + FilmDatabaseDao.columnId + "=" + id;
            return statement.execute(query);
        }
        catch (SQLException e){
            throw  new DaoException(e);
        }
    }

    @Override
    public boolean updateFilm(int id, Film newFilm) throws DaoException {
        try{
            String updString = "";
            updString += FilmDatabaseDao.columnId + "='" + newFilm.getId() + "',";
            updString += FilmDatabaseDao.columnTitle + "='" + newFilm.getTitle() + "',";
            updString += FilmDatabaseDao.columnDescription + "='" + newFilm.getDescription() + "',";
            updString += FilmDatabaseDao.columnDirector + "='" + newFilm.getDirector() + "',";
            updString += FilmDatabaseDao.columnGenre + "='" + newFilm.getGenre() + "',";
            updString += FilmDatabaseDao.columnDate + "='" + newFilm.getDate() + "'";
            String query = "UPDATE " + FilmDatabaseDao.tableName + " SET " + updString + " WHERE " + FilmDatabaseDao.columnId + "=" + id;
            return statement.execute(query);
        } catch (SQLException e){
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

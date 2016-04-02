package dao.databaseimpl;

import dao.DaoException;
import dao.FilmDao;
import entity.film.Film;
import entity.film.FilmGenre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public class FilmDatabaseDao extends Connector implements FilmDao {

    //Коммент
    private static FilmDatabaseDao instance = new FilmDatabaseDao();

    private FilmDatabaseDao() {
        super();
    }

    public static FilmDatabaseDao getInstance(){
        return instance;
    }

    @Override
    public Film findFilmByTitle() throws DaoException {
        return null;
    }

    @Override
    public List<Film> getFilmsCollections() throws DaoException {
        List<Film> films = new ArrayList<Film>();

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM film");

            while (resultSet.next()) {

                Film film = new Film();
                film.setId(resultSet.getInt("id"));
                film.setTitle(resultSet.getString("title"));
                film.setDescription(resultSet.getString("description"));
                film.setDirector(resultSet.getString("director"));
                film.setGenre(FilmGenre.valueOf(resultSet.getString("genre")));
                film.setDate(resultSet.getDate("date"));

                films.add(film);
            }

            return films;
        }
        catch (SQLException e){
            throw new DaoException(e);
        }
        finally {
            closeResultSet(resultSet);
        }
    }
}

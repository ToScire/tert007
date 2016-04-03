package dao.databaseimpl;

import dao.DaoException;
import dao.FilmDao;
import entity.film.Film;
import entity.film.FilmGenre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public class FilmDatabaseDao extends Connector implements FilmDao {

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

        /*
        try {
            Connection connection = Connector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM film");

            List<Film> films = new ArrayList<Film>();

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
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        */
        return null;
    }

}

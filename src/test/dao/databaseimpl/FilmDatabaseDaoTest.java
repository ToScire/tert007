package test.dao.databaseimpl;

import main.dao.databaseimpl.FilmDatabaseDao;
import main.entity.film.AgeLimitation;
import main.entity.film.Film;
import main.entity.film.FilmGenre;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alexander on 25.05.2016.
 */
public class FilmDatabaseDaoTest {
    private Film film = new Film();
    FilmDatabaseDao filmDatabaseDao = FilmDatabaseDao.getInstance();
    private int filmId;

    @Before
    public void setUp() throws Exception {


        String description = "des";
        String director = "des";
        String title = "t";

        film.setAgeLimitation(AgeLimitation.PG18);
        film.setDescription(description);
        film.setDirector(director);
        film.setTitle(title);
        film.setDate(new Date(12312312));
        film.setGenre(FilmGenre.DRAMA);

        filmDatabaseDao.addNewFilm(film);

        List<Film> films = filmDatabaseDao.getFilmsCollection();

        for (Film bufFilm: films) {
            if (bufFilm.getDescription().equals(description)){
                filmId = bufFilm.getId();
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        filmDatabaseDao.removeFilmById(filmId);
    }

    @Test
    public void testGetInstance() throws Exception {
        FilmDatabaseDao dao = FilmDatabaseDao.getInstance();
        assertTrue(dao instanceof FilmDatabaseDao);
    }

    @Test
    public void testFindFilmsByTitle() {
        try {
            List<Film> films = FilmDatabaseDao.getInstance().findFilmsByTitle("t");
            Film actualFilm = null;
            for (Film ubFilm : films) {
                if (ubFilm.getTitle().equals("t")) {
                    actualFilm = ubFilm;
                }
            }

            assertTrue(actualFilm.getId() == filmId);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void testFindFilmById() throws Exception {

    }

    @Test
    public void testFindFilmsByDate() throws Exception {

    }

    @Test
    public void testGetFilmsCollection() throws Exception {

    }

    @Test
    public void testAddNewFilm() throws Exception {

    }

    @Test
    public void testRemoveFilmById() throws Exception {

    }

    @Test
    public void testUpdateFilm() throws Exception {

    }
}
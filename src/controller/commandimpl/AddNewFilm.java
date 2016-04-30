package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import dao.DaoFactory;
import entity.film.Film;
import entity.film.FilmGenre;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by Alexander on 27.04.2016.
 */
public class AddNewFilm implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            Film test = new Film();
            test.setGenre(FilmGenre.COMEDY);
            test.setTitle("VADIM");
            test.setDirector("NEHAI");
            test.setDescription("FILM O BD");
            test.setDate(new Date(1461786130));
            test.setAgeLimitationId(1);
            test.setId(1);

            daoFactory.getFilmDao().addNewFilm(test);

            return "/result.jsp";
        } catch (Exception ex){
            return null;
        }
    }
}

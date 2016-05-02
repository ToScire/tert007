package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.film.Film;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Vadim on 04.04.2016.
 */
public class FindFilmByTitle implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();

        String title = request.getParameter("title");

        try {
            List<Film> films = daoFactory.getFilmDao().findFilmsByTitle(title);
            request.setAttribute("films", films);

            return PageHelper.getPage(PageName.FILMS_BY_TITLE_PAGE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

package main.controller.commandimpl;

import main.controller.Command;
import main.controller.CommandException;
import main.controller.PageHelper;
import main.controller.PageName;
import main.dao.DaoException;
import main.dao.DaoFactory;
import main.entity.film.Film;

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

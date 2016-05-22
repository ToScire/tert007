package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 01.05.2016.
 */
public class RemoveFilm implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            int id = Integer.parseInt(request.getParameter("film_id"));
            daoFactory.getFilmDao().removeFilmById(id);

            return PageHelper.getPage(PageName.FILMS_PAGE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

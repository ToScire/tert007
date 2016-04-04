package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import dao.DaoFactory;
import entity.film.Film;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Vadim on 04.04.2016.
 */
public class FindFilmById implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            Film film = daoFactory.getFilmDao().findFilmById(1);
            request.setAttribute("film", film);
            return "/result.jsp";
        } catch (Exception ex){
            return null;
        }
    }
}

package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.film.Film;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Vadim on 04.04.2016.
 */
public class FindFilmsByDate implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        String date = request.getParameter("date");

        try {
            List<Film> films = daoFactory.getFilmDao().findFilmsByDate(Date.valueOf(date));
            request.setAttribute("films", films);
            PageHelper pageHelper = new PageHelper();
            return pageHelper.getPage(PageName.FILMS_BY_DATE_PAGE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.film.Film;
import entity.hall.Hall;
import entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Alexander on 22.05.2016.
 */
public class FindSeancesByFilm implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            int filmId = Integer.parseInt(request.getParameter("id_film"));
            Film film = daoFactory.getFilmDao().findFilmById(filmId);

            if (film == null){
                throw new CommandException("Film id not found");
            }

            List<Seance> seances = daoFactory.getSeanceDao().findSeancesByFilm(film);
            request.setAttribute("seances",seances);

            return PageHelper.getPage(PageName.SEANCES_PAGE);
        }
        catch (DaoException ex){
            throw new CommandException(ex);
        }
    }
}

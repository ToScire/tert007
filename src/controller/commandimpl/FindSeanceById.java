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
 * Created by Vadim on 07.05.2016.
 */
public class FindSeanceById implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            int id = Integer.parseInt(request.getParameter("id_seance"));
            Seance seance = daoFactory.getSeanceDao().findSeanceById(id);
            List<Film> films = daoFactory.getFilmDao().getFilmsCollection();
            List<Hall> halls = daoFactory.getHallDao().getHallsCollection();
            request.setAttribute("seance",seance);
            request.setAttribute("films",films);
            request.setAttribute("halls",halls);
            return PageHelper.getPage(PageName.SEANCE_BY_ID);
        }
        catch (DaoException ex){
            throw new CommandException(ex);
        }
    }
}

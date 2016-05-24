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
import entity.ticket.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadim on 07.05.2016.
 */
public class FindSeanceById implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            int seanceId = Integer.parseInt(request.getParameter("seance_id"));

            Seance seance = daoFactory.getSeanceDao().findSeanceById(seanceId);
            List<Integer> busyPlaces = daoFactory.getSeanceDao().getBusyPlaces(seanceId);

            request.setAttribute("seance", seance);
            request.setAttribute("busyPlaces", busyPlaces);

            return PageHelper.getPage(PageName.SEANCE_BY_ID);
        }
        catch (DaoException ex){
            throw new CommandException(ex);
        }
    }
}

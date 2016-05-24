package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.ticket.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Vadim on 07.05.2016.
 */
public class FindTicketById implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();

        int ticketId = Integer.parseInt(request.getParameter("ticket_id"));

        try {
            Ticket ticket = daoFactory.getTicketDao().findTicketById(ticketId);
            int seanceId = ticket.getSeance().getId();


            List<Integer> busyPlaces = daoFactory.getSeanceDao().getBusyPlaces(seanceId);

            request.setAttribute("ticket", ticket);
            request.setAttribute("busyPlaces", busyPlaces);

            return PageHelper.getPage(PageName.FIND_TICKET_BY_ID);
        } catch (DaoException e) {
            throw new CommandException(e);
        }
    }
}

package main.controller.commandimpl;

import main.controller.Command;
import main.controller.CommandException;
import main.controller.PageHelper;
import main.controller.PageName;
import main.dao.DaoException;
import main.dao.DaoFactory;
import main.entity.ticket.Ticket;

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

            return PageHelper.getPage(PageName.TICKET_BY_ID);
        } catch (DaoException e) {
            throw new CommandException(e);
        }
    }
}

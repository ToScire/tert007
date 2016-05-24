package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import dao.DaoException;
import dao.DaoFactory;
import entity.ticket.Ticket;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 07.05.2016.
 */
public class RemoveTicket implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            int ticketId = Integer.valueOf(request.getParameter("ticket_id"));
            request.removeAttribute("ticket_id");

            Ticket ticket = daoFactory.getTicketDao().findTicketById(ticketId);
            daoFactory.getTicketDao().removeTicketById(ticketId);

            request.setAttribute("user_id", ticket.getUser().getId());

            return new FindUserById().execute(request);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

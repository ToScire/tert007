package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.seance.Seance;
import entity.ticket.Ticket;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alexander on 22.05.2016.
 */
public class BuyTicket implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            int place = Integer.parseInt(request.getParameter("place"));
            int seanceId = Integer.parseInt(request.getParameter("seance_id"));

            Seance seance = daoFactory.getSeanceDao().findSeanceById(seanceId);

            User user = (User)request.getSession().getAttribute("user");

            Ticket ticket = new Ticket();
            ticket.setUser(user);
            ticket.setPlace(place);
            ticket.setSeance(seance);

            daoFactory.getTicketDao().addNewTicket(ticket);

            return PageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

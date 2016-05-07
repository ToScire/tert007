package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.ticket.Ticket;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 07.05.2016.
 */
public class FindTicketById implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();

        int id = Integer.parseInt(request.getParameter("id"));
        Ticket ticket = null;

        try {
             ticket = daoFactory.getTicketDao().findTicketById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.setAttribute("ticket",ticket);
        return PageHelper.getPage(PageName.TICKETS_PAGE);
    }
}

package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.ticket.Ticket;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Alexander on 10.05.2016.
 */
public class FindUserByLogin implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            String login = request.getParameter("login");
            User user = daoFactory.getUserDao().findUser(login);

            if (user == null){
                request.setAttribute("error_login", login);
            } else {
                List<Ticket> tickets = daoFactory.getTicketDao().findTicketsByUserId(user.getId());

                request.setAttribute("user", user);
                request.setAttribute("tickets", tickets);
            }

            return PageHelper.getPage(PageName.USER_PROFILE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

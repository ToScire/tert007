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
 * Created by Vadim on 30.04.2016.
 */
public class FindUserById implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            int id = Integer.valueOf(request.getParameter("user_id"));
            User user = daoFactory.getUserDao().findUserById(id);


            if (user == null){
                return PageHelper.getPage(PageName.ERROR_REG_PAGE);

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

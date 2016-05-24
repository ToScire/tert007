package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 07.05.2016.
 */
public class GetTicketsCollection implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            daoFactory.getTicketDao().findTicketById(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }


        return PageHelper.getPage(PageName.MAIN_PAGE);
    }
}

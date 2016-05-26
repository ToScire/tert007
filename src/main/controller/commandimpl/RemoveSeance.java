package main.controller.commandimpl;

import main.controller.Command;
import main.controller.CommandException;
import main.controller.PageHelper;
import main.controller.PageName;
import main.dao.DaoException;
import main.dao.DaoFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 07.05.2016.
 */
public class RemoveSeance implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        int id = Integer.parseInt(request.getParameter("seance_id"));

        try {
            daoFactory.getSeanceDao().removeSeanceById(id);
        } catch (DaoException e) {
            throw new CommandException(e);
        }

        return PageHelper.getPage(PageName.SEANCES_PAGE);
    }
}

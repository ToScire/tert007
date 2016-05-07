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
public class AddNewSeanceForm implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            request.setAttribute("films", DaoFactory.getDaoFactory().getFilmDao().getFilmsCollection());
            request.setAttribute("halls",DaoFactory.getDaoFactory().getHallDao().getHallsCollection());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return PageHelper.getPage(PageName.ADD_NEW_SEANCE_FORM);
    }
}

package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import dao.DaoFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 04.04.2016.
 */
public class FindFilmsByDate implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();

        return null;
    }
}

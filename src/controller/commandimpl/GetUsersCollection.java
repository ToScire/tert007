package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.film.Film;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetUsersCollection implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            List<User> users = daoFactory.getUserDao().getUsersCollection();
            request.setAttribute("users", users);

            String page = PageHelper.getPage(PageName.USERS_PAGE);
            return page;
        } catch (DaoException e){
            throw new CommandException(e);
        }


    }
}

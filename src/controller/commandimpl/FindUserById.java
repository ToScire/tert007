package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;

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
            request.setAttribute("user", user);
            PageHelper pageHelper = new PageHelper();
            String page = pageHelper.getPage(PageName.USER_BY_ID_PAGE);
            return page;
        } catch (DaoException e){
            throw new CommandException(e);
        }

    }
}

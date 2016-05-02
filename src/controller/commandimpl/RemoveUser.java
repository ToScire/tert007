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
 * Created by Vadim on 01.05.2016.
 */
public class RemoveUser implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            int id = Integer.valueOf(request.getParameter("user_id"));
            daoFactory.getUserDao().removeUser(id);

            String page = PageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);
            return page;
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

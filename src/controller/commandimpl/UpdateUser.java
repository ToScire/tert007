package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoFactory;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 30.04.2016.
 */
public class UpdateUser implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            int bonus_count = Integer.parseInt(request.getParameter("bonus_count"));
            int user_type = 1;
            int id = Integer.parseInt(request.getParameter("id"));

            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setBonusCount(bonus_count);
            user.setUserType(user_type);
            user.setId(id);
            PageHelper pageHelper = new PageHelper();

            daoFactory.getUserDao().updateUser(id,user);
            request.setAttribute("user",user);
            return pageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);
        }
        catch (Exception ex){
            return null;
        }
    }
}
package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoFactory;
import entity.user.User;
import entity.user.UserType;

import javax.print.attribute.IntegerSyntax;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 30.04.2016.
 */
public class RegUser implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            int bonus_count = 0;
            int user_type = 1;

            User user = new User();
            user.setLogin(login);
            user.setPassword(password); // Доработать шифрование
            user.setEmail(email);
            user.setBonusCount(bonus_count);
            user.setUserType(user_type);

            PageHelper pageHelper = new PageHelper();

            daoFactory.getUserDao().addUser(user);
            request.setAttribute("user",user);
            return pageHelper.getPage(PageName.SUCCESS_REG_PAGE);
        }
        catch (Exception ex){
            return null;
        }
    }
}

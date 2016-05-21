package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.user.User;
import entity.user.UserType;

import javax.print.attribute.IntegerSyntax;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vadim on 30.04.2016.
 */
public class RegistrationUser implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            if (!validateParams(login, password, email)){
                String errorMessage = "Введены некорректные данные";

                request.setAttribute("errorMessage", errorMessage);
                return PageHelper.getPage(PageName.REGISTRATION);
            }

            if (daoFactory.getUserDao().findUser(login) == null) {
                User user = new User();

                user.setLogin(login);
                user.setPassword(password); // Доработать шифрование
                user.setEmail(email);
                user.setUserType(UserType.USER);

                daoFactory.getUserDao().addUser(user);
                request.setAttribute("user",user);

                request.getSession().setAttribute("login", login);
                request.getSession().setAttribute("userType", UserType.USER);

                return PageHelper.getPage(PageName.SUCCESS_REG_PAGE);
            } else {
                String errorMessage = "Данный логин уже занят";

                request.setAttribute("errorMessage", errorMessage);
                return PageHelper.getPage(PageName.REGISTRATION);
            }
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }

    private boolean validateParams(String login, String password, String email) {
        if (login.isEmpty() || password.isEmpty() || email.isEmpty()) {
            return false;
        }

        return true;
    }
}

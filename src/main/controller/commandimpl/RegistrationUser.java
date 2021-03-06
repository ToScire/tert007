package main.controller.commandimpl;

import main.controller.Command;
import main.controller.CommandException;
import main.controller.PageHelper;
import main.controller.PageName;
import main.dao.DaoException;
import main.dao.DaoFactory;
import main.entity.user.User;
import main.entity.user.UserType;

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
                return PageHelper.getPage(PageName.REGISTRATION_PAGE);
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

                return PageHelper.getPage(PageName.SIGN_IN_PAGE);
            } else {
                String errorMessage = "Данный логин уже занят";

                request.setAttribute("errorMessage", errorMessage);
                return PageHelper.getPage(PageName.REGISTRATION_PAGE);
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

package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Alexander on 07.05.2016.
 */
public class LoginUser implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            if (!validateParams(login, password)) {
                String errorMessage = "Введены некорректные данные";

                request.setAttribute("errorMessage", errorMessage);
                return PageHelper.getPage(PageName.SIGN_IN);
            }

            // Шифрование пароля
            User user = daoFactory.getUserDao().findUser(login);

            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                String remember = request.getParameter("remember");
                if( remember == "remember-me"){
                    session.setMaxInactiveInterval(1000*60);
                }

                return PageHelper.getPage(PageName.MAIN_PAGE);
            } else {
                String errorMessage = "Неверный логин или пароль";

                request.setAttribute("errorMessage", errorMessage);
                return PageHelper.getPage(PageName.SIGN_IN);
            }
        } catch (DaoException ex){
            throw new CommandException(ex);
        }
    }

    private boolean validateParams(String login, String password) {
       if (login.isEmpty() || password.isEmpty()) {
           return false;
       }

       return true;
    }
}

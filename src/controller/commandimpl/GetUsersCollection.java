package controller.commandimpl;

import controller.Command;
import dao.DaoFactory;
import entity.film.Film;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetUsersCollection implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            List<User> users = daoFactory.getUserDao().getUsersCollection();
            request.setAttribute("users", users);
            return "/result.jsp";
        } catch (Exception ex){
            return null;
        }


    }
}

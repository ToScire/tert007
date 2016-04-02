package controller.commandimpl;

import controller.Command;
import dao.DaoFactory;
import entity.film.Film;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public class GetFilmsCollection implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            List<Film> films = daoFactory.getFilmDao().getFilmsCollections();


            request.setAttribute("films", films);

            //Будет Enum со страницами
            return "/result.jsp";
        } catch (Exception ex){
            return null;
        }


    }
}

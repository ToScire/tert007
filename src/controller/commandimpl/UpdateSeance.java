package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.seance.Seance;
import entity.user.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Vadim on 07.05.2016.
 */
public class UpdateSeance implements Command{
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            Date date = Date.valueOf(request.getParameter("date"));
            int id = Integer.parseInt(request.getParameter("id"));
            int id_film = Integer.parseInt(request.getParameter("film_id"));
            int id_hall = Integer.parseInt(request.getParameter("hall_id"));
            Time time = Time.valueOf(request.getParameter("time"));
            int price = Integer.parseInt(request.getParameter("price"));

            Seance newSeance = new Seance();
            newSeance.setDate(date);
            newSeance.setFilm(daoFactory.getFilmDao().findFilmById(id_film));
            newSeance.setHall(daoFactory.getHallDao().findHallById(id_hall));
            newSeance.setId(id);
            newSeance.setTime(time);
            newSeance.setPrice(price);

            daoFactory.getSeanceDao().updateSeance(newSeance);
            return PageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);

        }catch (DaoException ex){
            throw new CommandException(ex);
        }
    }
}

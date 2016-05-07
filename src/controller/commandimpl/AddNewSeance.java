package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.film.Film;
import entity.hall.Hall;
import entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Vadim on 07.05.2016.
 */
public class AddNewSeance implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        Film film = null;
        Hall hall = null;
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            film = daoFactory.getFilmDao().findFilmById(Integer.parseInt(request.getParameter("id_film")));
            hall = daoFactory.getHallDao().findHallById(Integer.parseInt(request.getParameter("id_hall")));

            int price = Integer.parseInt(request.getParameter("price"));
            Time time = Time.valueOf(request.getParameter("time"));
            Date date = Date.valueOf(request.getParameter("date"));

            Seance seance = new Seance();
            seance.setHall(hall);
            seance.setFilm(film);
            seance.setDate(date);
            seance.setTime(time);
            seance.setPrice(price);
            daoFactory.getSeanceDao().addNewSeance(seance);
            return PageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);

        } catch (DaoException e) {
            e.printStackTrace();
        }


        return PageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);
    }
}

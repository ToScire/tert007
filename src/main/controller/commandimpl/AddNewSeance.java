package main.controller.commandimpl;

import main.controller.Command;
import main.controller.CommandException;
import main.controller.PageHelper;
import main.controller.PageName;
import main.dao.DaoException;
import main.dao.DaoFactory;
import main.entity.film.Film;
import main.entity.hall.Hall;
import main.entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:ss");

            java.util.Date date = dateFormat.parse(request.getParameter("date"));
            java.util.Date time = timeFormat.parse(request.getParameter("time"));

            long unixTime = date.getTime()+ time.getTime();


            Seance seance = new Seance();
            seance.setHall(hall);
            seance.setFilm(film);
            seance.setDate(unixTime);

            seance.setPrice(price);
            daoFactory.getSeanceDao().addNewSeance(seance);
            return PageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);

        } catch (ParseException e){
            throw new CommandException(e);
        } catch (DaoException e) {
            throw new CommandException(e);
        }
    }
}

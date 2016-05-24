package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Vadim on 07.05.2016.
 */
public class UpdateSeance implements Command{
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            Date date = dateFormat.parse(request.getParameter("date"));
            Date time = timeFormat.parse(request.getParameter("time"));

            long unixTime = date.getTime()+ time.getTime();

            int id = Integer.parseInt(request.getParameter("seance_id"));
            int id_film = Integer.parseInt(request.getParameter("film_id"));
            int id_hall = Integer.parseInt(request.getParameter("hall_id"));

            int price = Integer.parseInt(request.getParameter("price"));

            Seance newSeance = new Seance();

            newSeance.setFilm(daoFactory.getFilmDao().findFilmById(id_film));
            newSeance.setHall(daoFactory.getHallDao().findHallById(id_hall));
            newSeance.setId(id);
            newSeance.setDate(unixTime);
            newSeance.setPrice(price);

            daoFactory.getSeanceDao().updateSeance(newSeance);
            return PageHelper.getPage(PageName.SEANCES_PAGE);
        } catch (ParseException e) {
            throw new CommandException(e);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

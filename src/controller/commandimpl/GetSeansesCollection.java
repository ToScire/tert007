package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoFactory;
import entity.film.Film;
import entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Vadim on 07.05.2016.
 */
public class GetSeansesCollection implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            List<Seance> seances = daoFactory.getSeanceDao().getSeancesCollection(startDate,endDate);
            List<Film> films = daoFactory.getFilmDao().getFilmsCollection();
            request.setAttribute("seances",seances);
            request.setAttribute("films",films);
            return PageHelper.getPage(PageName.SEANCES_PAGE);

        }catch (Exception ex){
            throw new CommandException(ex);
        }
    }
}

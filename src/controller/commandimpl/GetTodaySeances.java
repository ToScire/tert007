package controller.commandimpl;

import controller.*;
import dao.DaoException;
import dao.DaoFactory;
import entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Alexander on 08.05.2016.
 */
public class GetTodaySeances implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            List<Seance> seances = daoFactory.getSeanceDao().getTodaySeances();
            request.setAttribute("seances", seances);
            return PageHelper.getPage(PageName.SEANCES_PAGE);
        }catch (DaoException ex){
            throw new CommandException(ex);
        }

    }
}

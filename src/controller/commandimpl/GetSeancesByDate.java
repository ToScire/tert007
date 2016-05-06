package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.hall.Hall;
import entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by Vadim on 07.05.2016.
 */
public class GetSeancesByDate implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            Date date = Date.valueOf(request.getParameter("date"));
            List<Seance> seances = daoFactory.getSeanceDao().findSeancesByDate(date);
            request.setAttribute("seances",seances);
            return PageHelper.getPage(PageName.SEANCES_PAGE);
        }catch (Exception ex){
            throw new CommandException(ex);
        }
    }
}

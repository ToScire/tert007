package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;

import java.sql.Date;
import java.util.List;

/**
 * Created by Alexander on 30.04.2016.
 */
public class FindSeancesByDate implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();

        String dateString = request.getParameter("date");
        Date date = Date.valueOf(dateString);

        try {
            List<Seance> seances = daoFactory.getSeanceDao().findSeancesByDate(date);
            request.setAttribute("seances", seances);

            PageHelper pageHelper = new PageHelper();

            return pageHelper.getPage(PageName.SEANCE_BY_DATE_PAGE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

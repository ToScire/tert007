package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoFactory;
import entity.seance.Seance;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Vadim on 07.05.2016.
 */
public class GetSeancesByDate implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDay = dateFormat.parse(request.getParameter("start_day"));
            Date finishDay = dateFormat.parse(request.getParameter("finish_day"));

            List<Seance> seances = daoFactory.getSeanceDao().findSeancesByDate(startDay, finishDay);
            request.setAttribute("seances",seances);
            return PageHelper.getPage(PageName.SEANCES_PAGE);
        }catch (Exception ex){
            throw new CommandException(ex);
        }
    }
}

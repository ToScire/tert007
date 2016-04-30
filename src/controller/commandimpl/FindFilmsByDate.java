package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoFactory;
import entity.film.Film;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.List;

/**
 * Created by Vadim on 04.04.2016.
 */
public class FindFilmsByDate implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try{
            Date date = Date.valueOf(request.getParameter("date"));
            List<Film> films = daoFactory.getFilmDao().findFilmsByDate(date);
            request.setAttribute("films",films);
            PageHelper pageHelper = new PageHelper();
            return pageHelper.getPage(PageName.FILMS_PAGE);
        }catch (Exception e){
            return null;
        }
    }
}

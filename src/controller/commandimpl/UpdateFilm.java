package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoFactory;
import entity.film.Film;
import entity.film.FilmGenre;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by Vadim on 01.05.2016.
 */
public class UpdateFilm implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String date = request.getParameter("date");
            String director = request.getParameter("director");
            int ageLimitation = Integer.parseInt(request.getParameter("age_limitation"));
            FilmGenre filmGenre = FilmGenre.valueOf(request.getParameter("genre"));


            Film film = new Film();
            film.setId(id);
            film.setTitle(title);
            film.setDescription(description);
            film.setGenre(filmGenre);
            film.setDate(Date.valueOf(date));
            film.setDirector(director);
            film.setAgeLimitationId(ageLimitation);

            PageHelper pageHelper = new PageHelper();
            daoFactory.getFilmDao().updateFilm(id,film);
            request.setAttribute("film",film);
            return pageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);
        }
        catch (Exception ex){
            return null;
        }
    }
}

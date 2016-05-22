package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.film.AgeLimitation;
import entity.film.Film;
import entity.film.FilmGenre;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            String director = request.getParameter("director");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

            long buf_date = 0;
            String date = request.getParameter("date");
            try {
                buf_date = simpleDateFormat.parse(date).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            AgeLimitation ageLimitation = AgeLimitation.valueOf(request.getParameter("age_limitation"));
            FilmGenre filmGenre = FilmGenre.valueOf(request.getParameter("genre"));

            Film film = new Film();

            film.setId(id);
            film.setTitle(title);
            film.setDescription(description);
            film.setGenre(filmGenre);
            film.setDate(new Date(buf_date));

            film.setDirector(director);
            film.setAgeLimitation(ageLimitation);

            daoFactory.getFilmDao().updateFilm(film);

            request.setAttribute("film",film);
            Command getFilmsCollectionms = new GetFilmsCollection();

            return getFilmsCollectionms.execute(request);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

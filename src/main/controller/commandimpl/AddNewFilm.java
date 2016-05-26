package main.controller.commandimpl;

import main.controller.Command;
import main.controller.CommandException;
import main.controller.PageHelper;
import main.controller.PageName;
import main.dao.DaoException;
import main.dao.DaoFactory;
import main.entity.film.AgeLimitation;
import main.entity.film.Film;
import main.entity.film.FilmGenre;


import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.IllegalFormatException;

/**
 * Created by Alexander on 27.04.2016.
 */
public class AddNewFilm implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        String statusMessage;
        try {
            int filmId = Integer.parseInt(request.getParameter("film_id"));

            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String date = request.getParameter("date");
            String director = request.getParameter("director");

            AgeLimitation ageLimitation = AgeLimitation.valueOf(request.getParameter("age_limitation"));
            FilmGenre filmGenre = FilmGenre.valueOf(request.getParameter("genre"));

            Film film = new Film();

            film.setId(filmId);
            film.setTitle(title);
            film.setDescription(description);
            film.setGenre(filmGenre);
            film.setDate(Date.valueOf(date));
            film.setDirector(director);
            film.setAgeLimitation(ageLimitation);

            daoFactory.getFilmDao().addNewFilm(film);

            statusMessage = "Данные успешно добалены";

            request.setAttribute("status_message", statusMessage);

            return PageHelper.getPage(PageName.FILM_BY_ID_PAGE);
        } catch (IllegalFormatException  e){
            statusMessage = "Ошибка в тиах-перечислителях";
            request.setAttribute("status_message", statusMessage);
            return PageHelper.getPage(PageName.FILM_BY_ID_PAGE);
        } catch (NumberFormatException e){
            statusMessage = "Неверные числовые значения";
            request.setAttribute("status_message", statusMessage);
            return PageHelper.getPage(PageName.FILM_BY_ID_PAGE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}

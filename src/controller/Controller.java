package controller;

import dao.databaseimpl.*;
import entity.seance.Seance;
import sun.java2d.pipe.SpanShapeRenderer;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Alexander on 16.02.2016.
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CommandHelper commandHelper = new CommandHelper();

        String action = request.getParameter("command");

        CommandName commandName = CommandName.valueOf(action.toUpperCase());
        Command command = commandHelper.getCommand(commandName);

        String page = null;

        try {
            page = command.execute(request);
        } catch (CommandException e) {
            request.setAttribute("error", e);
            page = "/error";
            // Заглушка
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}


package controller;

import controller.CommandHelper;
import controller.CommandName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Alexander on 16.02.2016.
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        } catch (Exception ex) {
            // Заглушка
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}


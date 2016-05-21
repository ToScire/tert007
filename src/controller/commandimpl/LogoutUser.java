package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Alexander on 07.05.2016.
 */
public class LogoutUser implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        HttpSession session = request.getSession();
        session.invalidate();

        //session.removeAttribute(RequestParameterName.USER);

        return PageHelper.getPage(PageName.MAIN_PAGE);
    }
}

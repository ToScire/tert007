package controller;

import controller.commandimpl.AddNewFilm;
import controller.commandimpl.GetFilmsCollection;
import controller.commandimpl.GetUsersCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander on 30.04.2016.
 */
public class PageHelper {
    private Map<PageName, String> pages = new HashMap<PageName, String>();

    public PageHelper(){
        pages.put(PageName.MAIN_PAGE, "/index.jsp");
        pages.put(PageName.USERS_PAGE, "/users.jsp");
        pages.put(PageName.USER_BY_ID_PAGE, "/user_by_id.jsp");
        pages.put(PageName.SUCCESS_REG_PAGE, "/success_reg.jsp");
        pages.put(PageName.ERROR_REG_PAGE, "/error_reg.jsp");
        pages.put(PageName.SUCCESS_UPDATE_PAGE, "/success_update.jsp");
        pages.put(PageName.SEANCE_BY_DATE_PAGE, "/seances.jsp");
    }

    public String getPage(PageName pageName){
        return pages.get(pageName);
    }
}

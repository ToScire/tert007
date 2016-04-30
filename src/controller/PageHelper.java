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
    }

    public String getPage(PageName pageName){
        return pages.get(pageName);
    }
}

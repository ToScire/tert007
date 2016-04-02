package controller;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public interface Command {
    String execute(HttpServletRequest request);
}

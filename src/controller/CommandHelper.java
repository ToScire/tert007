package controller;

import controller.commandimpl.GetFilmsCollection;
import controller.commandimpl.GetUsersCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander on 23.02.2016.
 */
public class CommandHelper {
    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

    public CommandHelper(){


        commands.put(CommandName.GET_FILMS_COLLECTION, new GetFilmsCollection());

        commands.put(CommandName.GET_USERS_COLLECTION, new GetUsersCollection());

    }

    public Command getCommand(CommandName commandName){
        return commands.get(commandName);
    }
}

package software.ulpgc.imageviewer.command;

import software.ulpgc.imageviewer.command.Command;

import java.util.HashMap;
import java.util.Map;

public class ImageCommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public void register(String name, Command command) {
        commands.put(name, command);
    }

    public void execute(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        }
    }
}

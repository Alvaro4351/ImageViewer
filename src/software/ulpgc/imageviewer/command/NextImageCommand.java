package software.ulpgc.imageviewer.command;

import software.ulpgc.imageviewer.ImagePresenter;
import software.ulpgc.imageviewer.command.Command;

public class NextImageCommand implements Command {
    private final ImagePresenter presenter;

    public NextImageCommand(ImagePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.next();
    }
}

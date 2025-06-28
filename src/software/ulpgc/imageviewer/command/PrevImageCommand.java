package software.ulpgc.imageviewer.command;

import software.ulpgc.imageviewer.ImagePresenter;
import software.ulpgc.imageviewer.command.Command;

public class PrevImageCommand implements Command {
    private final ImagePresenter presenter;

    public PrevImageCommand(ImagePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.prev();
    }
}

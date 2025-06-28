package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.ImageDisplay.*;
import software.ulpgc.imageviewer.command.ImageCommandManager;
import software.ulpgc.imageviewer.command.NextImageCommand;
import software.ulpgc.imageviewer.command.PrevImageCommand;

public class ImagePresenter {
    private final ImageDisplay display;
    private final ImageCommandManager commandManager;
    private Image image;

    public ImagePresenter(ImageDisplay display) {
        this.display = display;
        this.commandManager = new ImageCommandManager();
        this.display.on((Shift) this::shift);
        this.display.on((Released) this::released);
        setupCommands();
    }

    private void setupCommands() {
        commandManager.register("next", new NextImageCommand(this));
        commandManager.register("prev", new PrevImageCommand(this));
    }

    private void shift(int offset) {
        display.clear();
        display.paint(image.id(), offset);
        if (offset > 0)
            display.paint(image.prev().id(), offset - display.getWidth());
        else
            display.paint(image.next().id(), display.getWidth() + offset);
    }

    private void released(int offset) {
        if (Math.abs(offset) >= display.getWidth() / 2)
            image = offset > 0 ? image.prev() : image.next();
        repaint();
    }

    public void show(Image image) {
        this.image = image;
        repaint();
    }

    public void next() {
        image = image.next();
        repaint();
    }

    public void prev() {
        image = image.prev();
        repaint();
    }

    public void onKeyPressed(String keyEvent) {
        switch (keyEvent) {
            case "RIGHT":
            case "SPACE":
                commandManager.execute("next");
                break;
            case "LEFT":
            case "BACKSPACE":
                commandManager.execute("prev");
                break;
        }
    }

    private void repaint() {
        this.display.clear();
        this.display.paint(image.id(), 0);
    }
}
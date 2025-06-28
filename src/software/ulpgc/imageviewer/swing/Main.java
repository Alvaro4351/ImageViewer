package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.*;
import software.ulpgc.imageviewer.mocks.MockImageLoader;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(frame.getImageDisplay());

        frame.setPresenter(presenter);
        presenter.show(image());
        frame.setVisible(true);
    }

    private static Image image() {
        return new MockImageLoader().load();
    }
}
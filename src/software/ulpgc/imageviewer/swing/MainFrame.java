package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.ImageDisplay;
import software.ulpgc.imageviewer.ImagePresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private ImagePresenter presenter;

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createImageDisplay());
        setupKeyBindings();
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    public void setPresenter(ImagePresenter presenter) {
        this.presenter = presenter;
    }

    private Component createImageDisplay() {
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    private void setupKeyBindings() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (presenter != null) {
                    String keyName = getKeyName(e.getKeyCode());
                    if (keyName != null) {
                        presenter.onKeyPressed(keyName);
                    }
                }
            }
        });
        this.setFocusable(true);
    }

    private String getKeyName(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_RIGHT: return "RIGHT";
            case KeyEvent.VK_LEFT: return "LEFT";
            case KeyEvent.VK_SPACE: return "SPACE";
            case KeyEvent.VK_BACK_SPACE: return "BACKSPACE";
            default: return null;
        }
    }
}
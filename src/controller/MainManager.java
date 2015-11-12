package controller;

import view.MainFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Анатолий on 11.11.2015.
 */
public class MainManager {

    private static MainFrame mainFrame;

    public static void setMainFrame(MainFrame mainFrame) {
        MainManager.mainFrame = mainFrame;
    }

    public static void loadImageFromFile(File file, String projection) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
        }

        mainFrame.setProjectionImageToPanel(img, projection);
    }
}

package controller;

import modeling.Converter;
import modeling.Model;
import nets.Teacher;
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
    private static Model model;

    public static void setMainFrame(MainFrame mainFrame) {
        MainManager.mainFrame = mainFrame;
    }

    public static void init(){
        model = new Model();
    }

    public static void loadImageFromFile(File file, String projection) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
        }

        model.addProjectionMatrix(projection, Converter.convertTo2DWithoutUsingGetRGB(img)); //prepared img to analysis
        model.addProjectionImage(projection,img);
        mainFrame.setProjectionImageToPanel(img, projection); //add to view
    }
    public static void teachNeuroNet(String path){

    }
}

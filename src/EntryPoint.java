import view.MainFrame;

import javax.swing.*;

/**
 * Created by Анатолий on 01.11.2015.
 */
public class EntryPoint {

    public static void main(String[] args) {
        // TODO code application logic here
        /*int width = 900, height = 500;

        MainFrame mainFrame = new MainFrame();
        mainFrame.setSize(width, height);
        mainFrame.setTitle("Master's Project");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);*/
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){new MainFrame().setupUI();}
                }
        );
    }
}

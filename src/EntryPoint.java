import controller.MainManager;
import view.MainFrame;

import javax.swing.*;

/**
 * Created by Anatoliy on 01.11.2015.
 */
public class EntryPoint {

    public static void main(String[] args) {

        final MainFrame mainFrame = new MainFrame();
        MainManager.setMainFrame(mainFrame);

        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){mainFrame.setupUI();}
                }
        );
    }
}

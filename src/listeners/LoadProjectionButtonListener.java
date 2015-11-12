package listeners;

import controller.MainManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: ange0814
 * Date: 11.11.2015
 * Time: 12:55
 */
public class LoadProjectionButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        String commandLine = e.getActionCommand();
        final JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(((JButton)e.getSource()).getParent());

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            switch (commandLine) {
                case "loadFirstProjection": {
                    MainManager.loadImageFromFile(file, "firstProjection");
                    break;
                }
                case "loadSecondProjection":{
                    MainManager.loadImageFromFile(file, "secondProjection");
                    break;
                }
                case "loadThirdProjection":{
                    MainManager.loadImageFromFile(file, "thirdProjection");
                    break;
                }
            }
        }
    }
}

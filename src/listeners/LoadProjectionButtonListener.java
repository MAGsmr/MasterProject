package listeners;

import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        switch(commandLine){
            case "loadFirstProjection": break;
            case "loadSecondProjection": break;
            case "loadThirdProjection": break;
        }
    }
}

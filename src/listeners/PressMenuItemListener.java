package listeners;

import modeling.MyConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: ange0814
 * Date: 13.04.2016
 * Time: 13:16
 */
public class PressMenuItemListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String commandLine = e.getActionCommand();

        switch (commandLine) {
            case MyConstants.LOAD_WEIGHT: {
                final JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(((JMenuItem)e.getSource()).getParent());
            }
            case MyConstants.TEACH_NEURO_NET: {
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(((JMenuItem)e.getSource()).getParent());
            }
            case MyConstants.SAVE_WEIGHT: {
                final JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(((JMenuItem)e.getSource()).getParent());
            }
        }
    }
}

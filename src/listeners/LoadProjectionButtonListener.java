package listeners;

import controller.MainManager;
import modeling.FileFilterUtils;
import modeling.MyConstants;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
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
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()){
                    return true;
                }

                String extension = FileFilterUtils.getExtension(f);
                if(extension != null) {
                    if (extension.equals(FileFilterUtils.jpeg)||extension.equals(FileFilterUtils.jpg)){
                        return true;
                    } else {
                        return false;
                    }
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "JPEG and JPG files only";
            }
        });

        int result = fileChooser.showOpenDialog(((JMenuItem)e.getSource()).getParent());

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            switch (commandLine) {
                case MyConstants.TOP_PROJECTION: {
                    MainManager.loadImageFromFile(file, MyConstants.TOP_PROJECTION);
                    break;
                }
                case MyConstants.FRONT_PROJECTION:{
                    MainManager.loadImageFromFile(file, MyConstants.FRONT_PROJECTION);
                    break;
                }
                case MyConstants.LEFT_PROJECTION:{
                    MainManager.loadImageFromFile(file, MyConstants.LEFT_PROJECTION);
                    break;
                }
            }
        }
    }
}

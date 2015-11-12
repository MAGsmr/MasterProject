package view;

import listeners.LoadProjectionButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anatoliy on 01.11.2015.
 */
public class MainFrame extends JFrame{

    private JButton firstProjectionButton;
    private JButton secondProjectionButton;
    private JButton thirdProjectionButton;

    private Map<String, JPanel> allProjectionPanel = new HashMap<String, JPanel>();

    public void setupUI() {
        setDefaultLookAndFeelDecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(getContentPane());

        Insets insets = getInsets();
        setSize(640 + insets.left + insets.right, 480 + insets.top + insets.bottom);
        setLocation(500,100);
        setResizable(false);
        setVisible(true);
    }

    private void initComponents(Container pane) {
        pane.setLayout(null);

        //create buttons
        firstProjectionButton = new JButton("Загрузить проекцию");
        secondProjectionButton = new JButton("Загрузить проекцию");
        thirdProjectionButton = new JButton("Загрузить проекцию");

        //create listeners
        ActionListener loadProjectionListener = new LoadProjectionButtonListener();

        Insets insets = pane.getInsets();

        //configure buttons
        Dimension size = firstProjectionButton.getPreferredSize();
        firstProjectionButton.setBounds(40 + insets.left, 300 + insets.top, 160, 40);
        firstProjectionButton.setActionCommand("loadFirstProjection");
        firstProjectionButton.addActionListener(loadProjectionListener);

        secondProjectionButton.setBounds(240 + insets.left, 300 + insets.top, 160, 40);
        secondProjectionButton.setActionCommand("loadSecondProjection");
        secondProjectionButton.addActionListener(loadProjectionListener);

        thirdProjectionButton.setBounds(440 + insets.left, 300 + insets.top, 160, 40);
        thirdProjectionButton.setActionCommand("loadThirdProjection");
        thirdProjectionButton.addActionListener(loadProjectionListener);


        //add components to pane
        pane.add(firstProjectionButton);
        pane.add(secondProjectionButton);
        pane.add(thirdProjectionButton);

        pane.add(createProjectionPanel("firstProjection", 40, 40));
        pane.add(createProjectionPanel("secondProjection", 240, 40));
        pane.add(createProjectionPanel("thirdProjection", 440, 40));
    }

    private JPanel createProjectionPanel(String projection, int x, int y){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setBackground(Color.white);
        panel.setBounds(x + getInsets().left, y + getInsets().top, 160, 240);
        allProjectionPanel.put(projection, panel);
        return panel;
    }

    public void setProjectionImageToPanel(BufferedImage bufferedImage, String projection){
        JPanel panel = allProjectionPanel.get(projection);
        Graphics g = panel.getGraphics();
        g.drawImage(bufferedImage, 0, 0, panel.getWidth(), panel.getHeight(), null);
    }
}

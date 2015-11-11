package view;

import listeners.LoadProjectionButtonListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Anatoliy on 01.11.2015.
 */
public class MainFrame extends JFrame{

    public void setupUI() {
        setDefaultLookAndFeelDecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(getContentPane());

        Insets insets = getInsets();
        setSize(640 + insets.left + insets.right, 480 + insets.top + insets.bottom);
        setResizable(false);
        setVisible(true);
    }

    private void initComponents(Container pane) {
        pane.setLayout(null);

        //create buttons
        JButton firstProjectionButton = new JButton("Загрузить проекцию");
        JButton secondProjectionButton = new JButton("Загрузить проекцию");
        JButton thirdProjectionButton = new JButton("Загрузить проекцию");

        //create panels for projection
        JPanel firstProjectionPanel = new JPanel();
        JPanel secondProjectionPanel = new JPanel();
        JPanel thirdProjectionPanel = new JPanel();

        //create listeners
        ActionListener loadProjectionListener = new LoadProjectionButtonListener();

        //add components to pane
        pane.add(firstProjectionButton);
        pane.add(secondProjectionButton);
        pane.add(thirdProjectionButton);
        pane.add(firstProjectionPanel);
        pane.add(secondProjectionPanel);
        pane.add(thirdProjectionPanel);

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

        //configure panels
        firstProjectionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        firstProjectionPanel.setBackground(Color.white);
        firstProjectionPanel.setBounds(40 + insets.left, 40 + insets.top, 160, 240);

        secondProjectionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        secondProjectionPanel.setBackground(Color.white);
        secondProjectionPanel.setBounds(240 + insets.left, 40 + insets.top, 160, 240);

        thirdProjectionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        thirdProjectionPanel.setBackground(Color.white);
        thirdProjectionPanel.setBounds(440 + insets.left, 40 + insets.top, 160, 240);
    }
}

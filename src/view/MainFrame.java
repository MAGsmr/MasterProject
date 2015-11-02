package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Анатолий on 01.11.2015.
 */
public class MainFrame extends JFrame{

    public void setupUI() {
        setDefaultLookAndFeelDecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(getContentPane());

        Insets insets = getInsets();
        setSize(300 + insets.left + insets.right,
                125 + insets.top + insets.bottom);
        setVisible(true);
    }

    private void initComponents(Container pane) {
        pane.setLayout(null);

        JButton b1 = new JButton("one");
        JButton b2 = new JButton("two");
        JButton b3 = new JButton("three");
        JButton b4 = new JButton("four");

        pane.add(b1);
        pane.add(b2);
        pane.add(b3);

        Insets insets = pane.getInsets();
        Dimension size = b1.getPreferredSize();
        b1.setBounds(25 + insets.left, 5 + insets.top,
                size.width, size.height);
        size = b2.getPreferredSize();
        b2.setBounds(55 + insets.left, 40 + insets.top,
                size.width, size.height);
        size = b3.getPreferredSize();
        b3.setBounds(150 + insets.left, 15 + insets.top,
                size.width + 50, size.height + 20);
    }
}

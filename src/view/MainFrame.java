package view;

import com.sun.j3d.exp.swing.JCanvas3D;
import controller.MainManager;
import listeners.LoadProjectionButtonListener;
import listeners.PressMenuItemListener;
import modeling.MyConstants;
import test3d.Hello3D;

import javax.media.j3d.GraphicsConfigTemplate3D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anatoliy on 01.11.2015.
 */
public class MainFrame extends JFrame{

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    private Map<String, JPanel> allProjectionPanel = new HashMap<String, JPanel>();

    public void setupUI() {
        setDefaultLookAndFeelDecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(getContentPane());

        MainManager.init();

        Insets insets = getInsets();
        setSize(1280 + insets.left + insets.right, 865 + insets.top + insets.bottom);
        setLocation(200,0);
        setTitle("Simple 3D model generator");
        setResizable(false);
        setVisible(true);
    }

    private void initComponents(final Container pane) {
        pane.setLayout(null);
        Insets insets = pane.getInsets();

        //create listeners
        ActionListener loadProjectionListener = new LoadProjectionButtonListener();
        ActionListener pressMenuItemListener = new PressMenuItemListener();

        menuBar = new JMenuBar();

        menu = new JMenu("Load");
        menuBar.add(menu);
        menuItem = new JMenuItem("Top projection");
        menuItem.setActionCommand(MyConstants.TOP_PROJECTION);
        menuItem.addActionListener(loadProjectionListener);
        menu.add(menuItem);
        menuItem = new JMenuItem("Front projection");
        menuItem.setActionCommand(MyConstants.FRONT_PROJECTION);
        menuItem.addActionListener(loadProjectionListener);
        menu.add(menuItem);
        menuItem = new JMenuItem("Left projection");
        menuItem.setActionCommand(MyConstants.LEFT_PROJECTION);
        menuItem.addActionListener(loadProjectionListener);
        menu.add(menuItem);

        menu = new JMenu("NeuroNet");
        menuBar.add(menu);
        menuItem = new JMenuItem("Teach");
        menuItem.setActionCommand(MyConstants.TEACH_NEURO_NET);
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);

        setJMenuBar(menuBar);

        pane.add(createProjectionPanel(MyConstants.TOP_PROJECTION, 5, 5));
        pane.add(createProjectionPanel(MyConstants.FRONT_PROJECTION, 640, 5));
        pane.add(createProjectionPanel(MyConstants.LEFT_PROJECTION, 5, 410));
        final JPanel panel = createProjectionPanel(MyConstants.AXONOMETRIC, 640, 410);

        JCanvas3D canvas3D = new JCanvas3D(new GraphicsConfigTemplate3D());
        canvas3D.setSize(100,100);
        panel.setLayout(new BorderLayout());
        panel.add(canvas3D);
        Hello3D.init(canvas3D);
        //Position.init(canvas3D.getOffscreenCanvas3D());

        pane.add(panel);
    }

    private JPanel createProjectionPanel(String projection, int x, int y){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,1),projection));
        panel.setBackground(Color.white);
        panel.setBounds(x, y, 630, 400);
        allProjectionPanel.put(projection, panel);
        return panel;
    }

    public void setProjectionImageToPanel(BufferedImage bufferedImage, String projection){
        JPanel panel = allProjectionPanel.get(projection);
        Graphics g = panel.getGraphics();
        g.drawImage(bufferedImage, 5, 18, panel.getWidth()-10, panel.getHeight()-23, null);
    }
}

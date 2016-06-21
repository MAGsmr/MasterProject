package view;

import com.sun.j3d.exp.swing.JCanvas3D;
import controller.MainManager;
import figure3d.MyCube;
import figure3d.MyCylinder;
import figure3d.MySphere;
import listeners.LoadProjectionButtonListener;
import listeners.PressMenuItemListener;
import modeling.MyConstants;
import test3d.Hello3D;

import javax.media.j3d.GraphicsConfigTemplate3D;
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

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    public static int sizeWidth = 1320;
    public static int sizeHeight = 840;
    public static int locationX;
    public static int locationY;

    private Map<String, JPanel> allProjectionPanel = new HashMap<String, JPanel>();

    public void setupUI() {
        setDefaultLookAndFeelDecorated(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents(getContentPane());

        MainManager.init();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        locationX = (screenSize.width - sizeWidth) / 2;
        locationY = (screenSize.height - sizeHeight) / 2;
        setSize(sizeWidth, sizeHeight);
        setLocation(locationX, locationY);
        setTitle("Simple 3D model generator");
        setResizable(false);
        setVisible(true);
    }

    private void initComponents(final Container pane) {
        pane.setLayout(null);

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
        menuItem = new JMenuItem("Load weight");
        menuItem.setActionCommand(MyConstants.LOAD_WEIGHT);
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);
        menuItem = new JMenuItem("Teach");
        menuItem.setActionCommand(MyConstants.TEACH_NEURO_NET);
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save weight");
        menuItem.setActionCommand(MyConstants.SAVE_WEIGHT);
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);

        menu = new JMenu("Build");
        menuBar.add(menu);
        menuItem = new JMenuItem("By neuro net");
        menuItem.setActionCommand(MyConstants.BUILD_BY_NET);
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);
        menuItem = new JMenuItem("By algorithm");
        menuItem.setActionCommand(MyConstants.BUILD_BY_ALGORITHM);
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);
        menuItem = new JMenuItem("By all");
        menuItem.setActionCommand(MyConstants.BUILD_BY_ALL);
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);

        menu = new JMenu("Export 3D model");
        menuBar.add(menu);
        menuItem = new JMenuItem("To VRML");
        menuItem.setActionCommand("");
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);

        menu = new JMenu("Help");
        menuBar.add(menu);
        menuItem = new JMenuItem("About");
        menuItem.setActionCommand("");
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);
        menuItem = new JMenuItem("System help");
        menuItem.setActionCommand("");
        menuItem.addActionListener(pressMenuItemListener);
        menu.add(menuItem);

        setJMenuBar(menuBar);

        pane.add(createProjectionPanel(MyConstants.TOP_PROJECTION, 5, 5));
        pane.add(createProjectionPanel(MyConstants.FRONT_PROJECTION, 660, 5));
        pane.add(createProjectionPanel(MyConstants.LEFT_PROJECTION, 5, 380));
        final JPanel panel = createProjectionPanel(MyConstants.AXONOMETRIC, 660, 380);

        JCanvas3D canvas3D = new JCanvas3D(new GraphicsConfigTemplate3D());
        canvas3D.setSize(100,100);
        panel.setLayout(new BorderLayout());
        panel.add(canvas3D);
        MyCylinder.init(canvas3D);
        //Hello3D.init(canvas3D);
        //Position.init(canvas3D.getOffscreenCanvas3D());

        pane.add(panel);
    }

    private JPanel createProjectionPanel(String projection, int x, int y){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,1),projection));
        panel.setBackground(Color.white);
        panel.setBounds(x, y, 650, 370);
        allProjectionPanel.put(projection, panel);
        return panel;
    }

    public void setProjectionImageToPanel(BufferedImage bufferedImage, String projection){
        JPanel panel = allProjectionPanel.get(projection);
        Graphics g = panel.getGraphics();
        g.drawImage(bufferedImage, 5, 18, panel.getWidth()-10, panel.getHeight()-23, null);
    }

    public void repaintPanel(){
        final JPanel panel = allProjectionPanel.get(MyConstants.TOP_PROJECTION);
        panel.revalidate();
    }
}

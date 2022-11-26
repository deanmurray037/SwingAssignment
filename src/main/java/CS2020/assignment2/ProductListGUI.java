package CS2020.assignment2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class ProductListGUI {
    JTextArea output;
    JScrollPane scrollPane;
 
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("Actions");
        menuBar.add(menu);
 
        //a group of JMenuItems
        menuItem = new JMenuItem("About");
        menu.add(menuItem);

        menuItem = new JMenuItem("Import Data");
        menu.add(menuItem);

        menuItem = new JMenuItem("Inventory");
        menu.add(menuItem);

        menuItem = new JMenuItem("Export to CSV");
        menu.add(menuItem);

        return menuBar;
    }
 
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
 
        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
 
        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);
 
        return contentPane;
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("<Dean Murray> : Assignment 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        ProductListGUI menuGUI = new ProductListGUI();
        frame.setJMenuBar(menuGUI.createMenuBar());
        frame.setContentPane(menuGUI.createContentPane());
 
        //Display the window.
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
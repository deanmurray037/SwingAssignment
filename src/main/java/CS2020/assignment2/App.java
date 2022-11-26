package CS2020.assignment2;
import javax.swing.*;

public class App{
    public static void main(String[] args){
        
        ProductListGUI createGUI = new ProductListGUI();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI.createAndShowGUI();
            }
        });
    }
}
package battleship;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

public class Window extends JFrame{
    
    public Window()
    {   setVisible(true);
        setSize(1000,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        Gossiper mrGossip = new Gossiper();
    
        JSplitPane splitPane = new JSplitPane();
        Panelito leftPanel = new Panelito(mrGossip,1);
        Panelito rightPanel = new Panelito(mrGossip,2);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);  
        int middle = getSize().width/2;
        splitPane.setDividerLocation(middle);                    
        splitPane.setLeftComponent(leftPanel);                  
        splitPane.setRightComponent(rightPanel); 
        add(splitPane);
                
    }
    
    
}
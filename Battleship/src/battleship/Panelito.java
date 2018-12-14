package battleship;

import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panelito extends JPanel{
    private JButton[][] buttons;
    private Gossiper mrGossip;
    private int id;
    private int countShips = 5;

    public int getCountShips() {
        return countShips;
    }

    public void setCountShips(int countShips) {
        this.countShips = countShips;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
            
    public Panelito(Gossiper mg, int iden)
    {   mrGossip = mg;
        id = iden;
        GridLayout gl = new GridLayout(5, 5);
        buttons = new JButton[5][5];
        
        for (int i=0; i<5; i++)
            for (int j=0; j<5; j++)
            {   buttons[i][j] = new JButton();
                buttons[i][j].setText("");
                buttons[i][j].setActionCommand("");
                buttons[i][j].addActionListener(mrGossip);
                add(buttons[i][j]);
            }    
        setLayout(gl);
        
        int ships=0;
        Random r = new Random();
        while (ships <5)
        {   int x = r.nextInt(5);
            int y = r.nextInt(5);
            if (buttons[x][y].getActionCommand().length() == 0)
            {   buttons[x][y].setActionCommand("S");
                ships++;
            }    
        }
    }
}

package battleship;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Gossiper implements ActionListener {

    private boolean turn; //true P1, false P2

    public Gossiper() {
        Random r = new Random();
        if (r.nextInt(2) == 0) {
            turn = true;
        } else {
            
            turn = false;
        }
        if (turn) {
            JOptionPane.showMessageDialog(null, "Player 1 starts!");
        } else {
            JOptionPane.showMessageDialog(null, "Player 2 starts!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        Panelito pan = (Panelito) button.getParent();
        Random rand = new Random();
        int rPic = rand.nextInt(5);
        ImageIcon battleship = new ImageIcon("C:\\Users\\student\\Documents\\NetBeansProjects\\Battleship\\src\\battleship\\images\\bsExplosion" + rPic + ".jpg");
        
        if ((turn && pan.getId() == 1) || (!turn && pan.getId() == 2)) {
            JOptionPane.showMessageDialog(null, "Wrong Board Panel!!!");
        } else//I should check for hits or misses and potential Game over
        {
            if (button.getText() == "") {//checks to see if the button was clicked
                if (button.getActionCommand() == "S") {//checks to see if button had a ship
                    button.setText("*");
                    pan.setCountShips(pan.getCountShips() - 1);//decrement countShips
                    JOptionPane.showMessageDialog(null, "Player " + pan.getId() + " Ships Remaining: " + pan.getCountShips(), "Sunken Battleship", JOptionPane.INFORMATION_MESSAGE, battleship);
                } else {
                    button.setText("M");
                }
                turn = !turn;
            } else {
                
            }
            if (pan.getCountShips() == 0) {
                if (turn == false) {
                    JOptionPane.showMessageDialog(null, "Player 1 Wins!");
                } else {
                    JOptionPane.showMessageDialog(null, "Player 2 Wins!");
                }
                System.exit(0);
            }
        }
    }
}

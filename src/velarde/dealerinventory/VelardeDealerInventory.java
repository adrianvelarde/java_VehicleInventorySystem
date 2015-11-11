package velarde.dealerinventory;

import javax.swing.JFrame;

public class VelardeDealerInventory {

    public static void main(String[] args) 
    {
        InventorySystemGUI IS = new InventorySystemGUI();
        IS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IS.setSize(1000, 565);
        IS.setResizable(false);
        IS.setLocationRelativeTo(IS);
        IS.setVisible(true);
    }
    
}

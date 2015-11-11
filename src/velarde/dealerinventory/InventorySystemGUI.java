package velarde.dealerinventory;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
********************************************************************************
*** Class Name: InventorySystemGUI
*** Class Author: Adrian Velarde
********************************************************************************
*** This class is used to create the GUI for the Vehicle Inventory System.
********************************************************************************
*** October 12, 2015.
********************************************************************************
*** List of changes with dates: No changes after completion.
********************************************************************************
**/
public class InventorySystemGUI extends JFrame
{
    //GUI related///////////////////////////////////////////////////////////////
    private final JButton btnAdd, btnCalcCommission, btnGoLeft, btnGoRight, btnSell, btnRead, btnWrite;
    private final JTextField txtAskingPrice, txtCustOffer, txtMake, txtModel, txtPurchasePrice, txtSalesCommission, txtUnique1, txtUnique2;
    private final JTextArea txtVehicleSpecs;
    private final JComboBox<String> cbxType;
    private final JScrollPane jScrollPane1;
    private final JSpinner spnNumPass;
    private final JSeparator jSeparator1;   //may not use
    //static labels
    private final JLabel lblAskingPrice, lblCustOffer, lblMake, lblModel, lblNumPass, lblPurchasePrice, lblSalesCommission, lblTotalVehicles, lblType, lblVehicleInfo, lblWatermark;
    //dynamic labels
    private final JLabel lblMsg, lblUnique1, lblUnique2, lblTotalSpecific, lblVehicleTotal, lblTypeTotal;
    
    private final Font fontSegoeUI12 = new Font("Segoe UI", 0, 12);
    private final GridLayout grid;
    
    //code related//////////////////////////////////////////////////////////////
    private final int NUM_VEHICLES = 50;
    private Vehicle[] vehicle = new Vehicle[NUM_VEHICLES];
    private ArrayList<javax.swing.text.JTextComponent> fields = new ArrayList();
    private ArrayList<javax.swing.JComponent> components = new ArrayList();
    private final String[] VEHICLE_TYPE = {"Car", "Bus", "Boat"};
    private int nextSpot = 0;
    private int currentVehicle = 0;
    private final SpinnerNumberModel spnmCarMaxPassenger = new SpinnerNumberModel(1, 1, 8, 1), 
            spnmBusMaxPassenger = new SpinnerNumberModel(1, 1, 36, 1), 
            spnmBoatMaxPassenger = new SpinnerNumberModel(1, 1, 15, 1);
    
    private final int COMPONENT_WIDTH = 125;
    private final int COMPONENT_HEIGHT = 75;
    
    public InventorySystemGUI()
    {
        super("Vehicle Inventory System");
        //IMPORTANT! Do NOT reorder components. Order of instantiation is appearance on GUI
        //top 1/3
        lblType = new JLabel("Type: ");
        components.add(lblType);
        cbxType = new JComboBox();
        components.add(cbxType);
        lblMake = new JLabel("Make: ");
        components.add(lblMake);
        txtMake = new JTextField();
        components.add(txtMake);
        lblModel = new JLabel("Model: ");
        components.add(lblModel);
        txtModel = new JTextField();
        components.add(txtModel);
        lblUnique1 = new JLabel("Number of Doors: ");
        components.add(lblUnique1);
        txtUnique1 = new JTextField();
        components.add(txtUnique1);
        lblUnique2 = new JLabel("Miles Per Gallon");
        components.add(lblUnique2);
        txtUnique2 = new JTextField();
        components.add(txtUnique2);
        lblNumPass = new JLabel("Number of Passengers: ");
        components.add(lblNumPass);
        spnNumPass = new JSpinner();
        components.add(spnNumPass);
        lblPurchasePrice = new JLabel("Purchase Price: ");
        components.add(lblPurchasePrice);
        txtPurchasePrice = new JTextField();
        components.add(txtPurchasePrice);
        lblAskingPrice = new JLabel("Asking Price: ");
        components.add(lblAskingPrice);
        txtAskingPrice = new JTextField();
        components.add(txtAskingPrice);
        components.add(new JLabel());   //placeholder for space. delete when learn to position components
        btnAdd = new JButton("Add - - -");
        components.add(btnAdd);
        
        //middle 1/3
        lblTotalVehicles = new JLabel("Total Vehicles: ");
        components.add(lblTotalVehicles);
        lblVehicleTotal = new JLabel("- - -");
        components.add(lblVehicleTotal);
        btnGoLeft = new JButton("<---");
        components.add(btnGoLeft);
        lblVehicleInfo = new JLabel("Vehicle Info");
        //components.add(lblVehicleInfo);   //uncomment when learn to position components
        btnGoRight = new JButton("--->");
        components.add(btnGoRight);
        lblTotalSpecific = new JLabel("Total Cars: ");
        components.add(lblTotalSpecific);
        lblTypeTotal = new JLabel("- - -");
        components.add(lblTypeTotal);
        components.add(new JLabel());   //placeholder for space. delete when learn to position components
        txtVehicleSpecs = new JTextArea();
        jScrollPane1 = new JScrollPane(txtVehicleSpecs);
        components.add(jScrollPane1);
        
        //bottom 1/3
        components.add(new JLabel("Message: "));   //placeholder for space. delete when learn to position components
        lblMsg = new JLabel("- - -");
        components.add(lblMsg);
        lblCustOffer = new JLabel("Customer Offer: ");
        components.add(lblCustOffer);
        txtCustOffer = new JTextField();
        components.add(txtCustOffer);
        lblSalesCommission = new JLabel("Sales Commission: ");
        components.add(lblSalesCommission);
        txtSalesCommission = new JTextField();
        components.add(txtSalesCommission);
        btnCalcCommission = new JButton("Calculate Commission");
        components.add(btnCalcCommission);
        btnSell = new JButton("Sell - - -");
        components.add(btnSell);
        btnRead = new JButton("Load Vehicles");
        components.add(btnRead);
        btnWrite = new JButton("Save Vehicles");
        components.add(btnWrite);
        components.add(new JLabel());   //placeholder for space. delete when learn to position components
        lblWatermark = new JLabel("Adrian Velarde - Software Engineering Student");
        components.add(lblWatermark);
        //can't implement with GridLayout
        jSeparator1 = new JSeparator(); //May throw out
        
        grid = new GridLayout(19, 2, 5, 5);
        setLayout(grid);
        ////////////////////////////////////////////////////////////////////////
        //Event Handlers
        ////////////////////////////////////////////////////////////////////////
        btnAdd.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent event) 
            { btnAddActionPerformed(event); }
        });
        
        btnCalcCommission.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            { btnCalcCommissionActionPerformed(event); }
        });
        
        btnGoLeft.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            { btnGoLeftActionPerformed(event); }
        });
        
        btnGoRight.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            { btnGoRightActionPerformed(event); }
        });
        
        btnSell.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            { btnSellActionPerformed(event); }
        });
        
        btnRead.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            { btnReadActionPerformed(event); }
        });
        
        btnWrite.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            { btnWriteActionPerformed(event); }
        });
        
        cbxType.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent event)
            { cbxTypeItemStateChanged(event); }
        });
        
        //populate the JFrame
        for(JComponent jc : components)
        {
            jc.setFont(fontSegoeUI12);
            jc.setSize(COMPONENT_WIDTH, COMPONENT_HEIGHT);
            add(jc);
        }
        
        //prepare GUI for use
        for(String c : VEHICLE_TYPE)
        { cbxType.addItem(c); }
        spnNumPass.setModel(spnmCarMaxPassenger);
        fields.add(txtMake);
        fields.add(txtModel);
        fields.add(txtUnique1);
        fields.add(txtUnique2);
        fields.add(txtPurchasePrice);
        fields.add(txtAskingPrice);
        clearFields();
    }
    
    /**
    ****************************************************************************
    ***  Event Name: btnAddActionPerformed
    ***  Event Author: Adrian Velarde
    ****************************************************************************
    *** This particular Event is intended to add a new Vehicle object to an
    *** array, activate the appropriate buttons, and update the text area if it 
    *** is the first vehicle added.
    *** Event Inputs: ActionEvent evt.
    *** Return value: void.
    ****************************************************************************
    *** September 14, 2015.
    ****************************************************************************
    **/
    private void btnAddActionPerformed(ActionEvent evt) {                                       
        //every time add button press, increments car, boat, or bus count
        //no matter if an ArgumentOutOfBoundsException is thrown.
        //increment is in constructor.
        //FIXED: ArgumentOutOfBoundsException, find an instance of same type and
        //decrement it if present.
        try
        {
            if(checkFields())
            { 
                //information similar in all vehicle types
                int passCount = Integer.parseInt(spnNumPass.getValue().toString());
                String make = txtMake.getText();
                String model = txtModel.getText();
                int purchasePrice = Integer.parseInt(txtPurchasePrice.getText());
                int askingPrice = Integer.parseInt(txtAskingPrice.getText());
                
                //information individual to vehicle type
                switch(cbxType.getSelectedItem().toString())
                {
                    case "Car":
                    {
                        int doorCount = Integer.parseInt(txtUnique1.getText());
                        double mpg = Double.parseDouble(txtUnique2.getText());
                        addCar(passCount, doorCount, mpg, make, model, purchasePrice, askingPrice);
                        break;
                    }
                    case "Bus":
                    {
                        int length = Integer.parseInt(txtUnique1.getText());
                        boolean diesel = false;
                        if(lblUnique2.getText().equals("Diesel: "))
                        {
                            if(txtUnique2.getText().toLowerCase().equals("yes"))
                            { diesel = true; }
                            else if(txtUnique2.getText().toLowerCase().equals("no"))
                            { diesel = false; }
                            else
                            { throw new Exception("The Diesel field should be entered as \"yes\" or \"no\""); }
                        }
                        addBus(length, passCount, diesel, make, model, purchasePrice, askingPrice);
                        break;
                    }
                    case "Boat":
                    {
                        int weight = Integer.parseInt(txtUnique1.getText());
                        int totalHP = Integer.parseInt(txtUnique2.getText());
                        addBoat(weight, passCount, totalHP, make, model, purchasePrice, askingPrice);
                        break;
                    }
                } 
            }
            else
            { throw new Exception("You must input all the information before you add a vehicle."); }
            clearFields();
            displayCurVehicle(currentVehicle);
        }
        catch(ArrayIndexOutOfBoundsException obx)
        { 
            //set nextSpot to end or else it increments every button press regardless of Exception
            nextSpot = vehicle.length;  
            //find index of first instance. -1 if none found
            int index = findFirstInstance(cbxType.getSelectedItem().toString());
            //catch because constructor in addCar, addBus, and addBoat increments static count variable, THEN throws exception
            //remove(decrement) vehicle type if present. Doesn't actually remove vehicle! 
            //if not present, don't need to decrement because will not go below 0
            if(index != -1)
            { vehicle[index].remove(); }
            
            lblMsg.setText("That's the maximum amount of vehicles you can enter."); 
        }
        catch(NumberFormatException nfe)
        {
            switch(cbxType.getSelectedItem().toString())
            {
                case "Car":
                { 
                    lblMsg.setText("Make sure the fields \"Number of Doors\", \"Miles Per Gallon\", \"Number of Passengers\", \"Purchasing Price\", and \"Asking Price\" each contain numbers."); 
                    break;
                }
                case "Bus":
                { 
                    lblMsg.setText("Make sure the fields \"Length\", \"Number of Passengers\", \"Purchasing Price\", and \"Asking Price\" each contain numbers."); 
                    break;
                }
                case "Boat":
                { 
                    lblMsg.setText("Make sure the fields \"Weight\", \"Total Horsepower\", \"Number of Passengers\", \"Purchasing Price\", and \"Asking Price\" each contain numbers."); 
                    break;
                }
            } 
        }
        catch(Exception ex)
        { lblMsg.setText(ex.getMessage()); }
    }                                      

    /**
    ****************************************************************************
    ***  Event Name: btnGoLeftActionPerformed
    ***  Event Author: Adrian Velarde
    ****************************************************************************
    *** This particular Event is intended to display the previous Car object in
    *** the GUI's text area.
    *** Event Inputs: ActionEvent evt.
    *** Return value: void.
    ****************************************************************************
    *** September 14, 2015.
    ****************************************************************************
    *** November 1, 2015: Added outermost if statement
    ****************************************************************************
    **/
    private void btnGoLeftActionPerformed(ActionEvent evt) 
    {                                          
        if(!displayNumberOfVehicles().equals("0"))
        {
            moveToPrevVehicle();
            clearFields();
            resetMessage();
        }
        else
        { lblMsg.setText("There aren't any vehicles in the system."); }
    }                                         

    /**
    ****************************************************************************
    ***  Event Name: btnGoRightActionPerformed
    ***  Event Author: Adrian Velarde
    ****************************************************************************
    *** This particular Event is intended to display the next Car object in the
    *** GUI's text area.
    *** Event Inputs: ActionEvent evt.
    *** Return value: void.
    ****************************************************************************
    *** September 14, 2015.
    ****************************************************************************
    *** November 1, 2015: Added outermost if statement
    ****************************************************************************
    **/
    private void btnGoRightActionPerformed(ActionEvent evt) 
    {                                           
        if(!displayNumberOfVehicles().equals("0"))
        {
            moveToNextVehicle();
            clearFields();
            resetMessage();
        }
        else
        { lblMsg.setText("There aren't any vehicles in the system."); }
    }                                          

    /**
    ****************************************************************************
    ***  Event Name: btnSellActionPerformed
    ***  Event Author: Adrian Velarde
    ****************************************************************************
    *** This particular Event is intended to simulate a car being sold. It
    *** ensures the car is being sold for a reasonable price and updates the
    *** vehicle count.
    *** Event Inputs: ActionEvent evt.
    *** Return value: void.
    ****************************************************************************
    *** September 28, 2015.
    ****************************************************************************
    *** November 1, 2015: Added outermost if statement
    ****************************************************************************
    **/
    private void btnSellActionPerformed(ActionEvent evt) 
    {         
        if(!displayNumberOfVehicles().equals("0"))
        {
            try
            { 
                int offer = Integer.parseInt(txtCustOffer.getText());
                if(!txtSalesCommission.getText().equals("") && vehicle[currentVehicle] != null)
                { 
                    if(offer >= vehicle[currentVehicle].getPurchasePrice())
                    { removeCurVehicle(); }
                    else
                    { throw new Exception("The Customer Offer was declined because it was too low."); }
                }
                else
                { throw new Exception("You must calculate the commission before deciding to sell the vehicle."); }
                txtVehicleSpecs.setText("");

                displayCurVehicle(currentVehicle);
                if(displayNumberOfVehicles().equals("0"))
                { 
                    lblTotalSpecific.setText("Total Cars :");
                    lblTypeTotal.setText("--");
                }
                clearFields();
            }
            catch(NumberFormatException nfe)
            { lblMsg.setText("The Customer Offer must be a number."); }
            catch(Exception ex)
            { lblMsg.setText(ex.getMessage()); }
        }
        else
        { lblMsg.setText("There aren't any vehicles in the system."); }
    }                                          

    /**
    ****************************************************************************
    ***  Event Name: btnReadActionPerformed
    ***  Event Author: Adrian Velarde
    ****************************************************************************
    *** Allows user to select a file to read vehicle objects from. 
    *** Event Inputs: ActionEvent evt.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015
    ****************************************************************************
    **/
    private void btnReadActionPerformed(ActionEvent evt) 
    {
        ReadWrite reader = new ReadWrite();
        
        try
        { 
            if(reader.getFileName(true))    //successfully selected a file
            {
                reader.openReader();
                int index = 0;
                Object obj;
                //temporary copy. failsafe, rolls back incase of ArrayIndexOutOfBoundsException
                Vehicle[] tmp = new Vehicle[NUM_VEHICLES];
                //assign to obj before comparison
                while((obj = reader.read()) != null)
                {
                    switch(getVehicleClass((Vehicle) obj))
                    {
                        case "Car":
                        { tmp[index++] = (Car)obj; break; }
                        case "Bus":
                        { tmp[index++] = (Bus)obj; break; }
                        case "Boat":
                        { tmp[index++] = (Boat)obj; break; }
                    } 
                }
                int startLocation = nextSpot;
                //clearVehicleList(); //no error when reading so clear current list
                for(int i = 0; i < tmp.length; i++) //no error, so copy array over
                { 
                    if(tmp[i] == null)
                    { break; }
                    else 
                    { vehicle[nextSpot++] = tmp[i]; }
                }
                tallyVehicleType(startLocation); //count vehicles before displaying them
                displayCurVehicle(currentVehicle = 0);
                setNextAvailableSpot();
                clearFields();
            }
            else
            { throw new Exception("File selection process canceled."); }
        }
        catch(ArrayIndexOutOfBoundsException obx)
        { lblMsg.setText(String.format("There were too many vehicles to load (Max %s).", NUM_VEHICLES)); }
        catch(Exception ex)
        { lblMsg.setText(ex.getMessage()); }
        finally
        { reader.closeReader(); }
    }                                                 

    /**
    ****************************************************************************
    ***  Event Name: btnWriteActionPerformed
    ***  Event Author: Adrian Velarde
    ****************************************************************************
    *** Allows user to select a file to save vehicle objects in. 
    *** Event Inputs: ActionEvent evt.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015
    ****************************************************************************
    **/
    private void btnWriteActionPerformed(ActionEvent evt) 
    {
        if(!displayNumberOfVehicles().equals("0"))  //there are vehicles to save
        {
            ReadWrite writer = new ReadWrite();
            try
            { 
                if(writer.getFileName(false)) //successfully selected a file
                {
                    writer.openWriter();
                    for(Vehicle veh : vehicle)
                    { writer.write(veh); }
                    lblMsg.setText("File Saved!"); 
                }
            }
            catch(Exception ex)
            { lblMsg.setText(ex.getMessage()); }
            finally
            { writer.closeWriter(); }
        }
        else
        { lblMsg.setText("There must be vehicles in the system to save."); }
        
    }                                              

    /**
    ****************************************************************************
    ***  Event Name: cbxTypeItemStateChanged
    ***  Event Author: Adrian Velarde
    ****************************************************************************
    *** This particular Event is intended to modify the labels and buttons so
    *** that they are unique to the type of vehicle the user has selected to
    *** add.
    *** Event Inputs: ItemEvent evt.
    *** Return value: void.
    ****************************************************************************
    *** September 28, 2015.
    ****************************************************************************
    **/
    private void cbxTypeItemStateChanged(ItemEvent evt) {                                         
        String type = cbxType.getSelectedItem().toString();
        btnAdd.setText(String.format("Add %s", type));  //change Add button Text
        //change label text based on type selected
        switch(type)
        {
            case "Car":
            {
                spnNumPass.setModel(spnmCarMaxPassenger);
                lblUnique1.setText("Number of Doors: ");
                lblUnique2.setText("Miles Per Gallon: ");
                break;
            }
            case "Bus":
            {
                spnNumPass.setModel(spnmBusMaxPassenger);
                lblUnique1.setText("Length: ");
                lblUnique2.setText("Diesel: ");
                break;
            }
            case "Boat":
            {
                spnNumPass.setModel(spnmBoatMaxPassenger);
                lblUnique1.setText("Weight: ");
                lblUnique2.setText("Total Horsepower: ");
                break;
            }
        } 
    }                                        

    /**
    ****************************************************************************
    ***  Event Name: btnCalcCommissionActionPerformed
    ***  Event Author: Adrian Velarde
    ****************************************************************************
    *** Calculates the commission based on the customer's offer.
    *** Event Inputs: ActionEvent evt.
    *** Return value: void.
    ****************************************************************************
    *** September 28, 2015.
    ****************************************************************************
    *** November 1, 2015: Added outermost if statement
    ****************************************************************************
    **/
    private void btnCalcCommissionActionPerformed(ActionEvent evt) 
    {                                                  
        if(!displayNumberOfVehicles().equals("0"))
        {
            try
            {
                lblMsg.setText("- - -");
                if(!txtCustOffer.getText().equals("") && vehicle[currentVehicle] != null)
                { 
                    int custOffer;
                    try  
                    { custOffer = Integer.parseInt(txtCustOffer.getText()); }
                    catch(NumberFormatException nfe)
                    { throw new NumberFormatException("The Customer offer must be a number."); }

                    if(acceptCustOfferOnCurrVehicle(custOffer))
                    { txtSalesCommission.setText(String.format("$%,2d", salesCommission(custOffer))); }
                    else
                    { throw new Exception("The offer was declined because it was lower than the purchase price."); } 
                }
                else
                { throw new Exception("There must be a vehicle to sell and a Customer Offer to sell it."); }
            }
            catch(Exception ex)
            {  lblMsg.setText(ex.getMessage()); }
        }
        else
        { lblMsg.setText("There aren't any vehicles in the system."); }
    }        
    
    /**
    ****************************************************************************
    ***  Method Name: acceptCustOfferOnCurrVehicle
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Determines if the customer's offer is good enough for a deal.
    *** Method Inputs: N/A.
    *** Return value: boolean.
    ****************************************************************************
    *** September 28, 2015.
    ****************************************************************************
    **/
    private boolean acceptCustOfferOnCurrVehicle(int custOffer)
    { return vehicle[currentVehicle].deal(custOffer); }
    
    /**
    ****************************************************************************
    ***  Method Name: addCar
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Adds a new Car object to the vehicle array and increments the nextSpot
    *** variable so that the next object will be added in the correct spot.
    *** Method Inputs: int passCount, int doorCount, double mpg, String make, 
    ***String model, int purchasePrice, int askingPrice.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    private void addCar(int passCount, int doorCount, double mpg, String make, String model, int purchasePrice, int askingPrice)
    { vehicle[nextSpot++] = new Car(passCount, doorCount, mpg, make, model, purchasePrice, askingPrice); }
    
    /**
    ****************************************************************************
    ***  Method Name: addBus
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Adds a new Bus object to the vehicle array and increments the nextSpot
    *** variable so that the next object will be added in the correct spot.
    *** Method Inputs: int length, int passCount, boolean diesel, String make, 
    *** String model, int purchasePrice, int askingPrice
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    private void addBus(int length, int passCount, boolean diesel, String make, String model, int purchasePrice, int askingPrice)
    { vehicle[nextSpot++] = new Bus(length, passCount, diesel, make, model, purchasePrice, askingPrice); }
    
    /**
    ****************************************************************************
    ***  Method Name: addBoat
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Adds a new Boat object to the vehicle array and increments the nextSpot
    *** variable so that the next object will be added in the correct spot.
    *** Method Inputs: int weight, int passCount, int totalHP, String make, 
    *** String model, int purchasePrice, int askingPrice
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    private void addBoat(int weight, int passCount, int totalHP, String make, String model, int purchasePrice, int askingPrice)
    { vehicle[nextSpot++] = new Boat(weight, passCount, totalHP, make, model, purchasePrice, askingPrice); }
    
    /**
    ****************************************************************************
    ***  Method Name: findFirstInstance
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Finds the first instance of the class that was passed and returns its
    *** location.
    *** Returns a -1 if the vehicle class was not found.
    *** Method Inputs: String vehType.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    private int findFirstInstance(String vehType)
    {
        for(int i = 0; i < nextSpot; i++)
        {
            if(vehType.equals(getVehicleClass(vehicle[i])))
            { return i; }
        }
        return -1;
    }
    
    /**
    ****************************************************************************
    ***  Method Name: checkFields
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** This particular Method is intended to check the textbox fields to see if
    *** any one of them is empty.
    *** Method Inputs: N/A.
    *** Return value: boolean.
    ****************************************************************************
    *** September 14, 2015.
    ****************************************************************************
    **/
    private boolean checkFields()
    {
        for(javax.swing.text.JTextComponent j : fields)
        { if(j.getText().equals("")) 
          { return false; }
        }
        return true;
    }
    
    /**
    ****************************************************************************
    ***  Method Name: clearFields
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** This particular Method is intended to clear the textbox fields on the 
    *** GUI.
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** September 14, 2015.
    ****************************************************************************
    **/
    private void clearFields()
    {
        for(javax.swing.text.JTextComponent j : fields)
        { j.setText(""); }
        txtCustOffer.setText("");
        txtSalesCommission.setText("");
        resetMessage();
    }
    
    /**
    ****************************************************************************
    ***  Method Name: clearVehicleList
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Removes all vehicles from the vehicle array
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    private void clearVehicleList()
    { 
        for(int i = 0; i < vehicle.length; i++)
        {    
            if(vehicle[i] != null)
            { 
                vehicle[i].remove();
                vehicle[i] = null;
            } 
        } 
    }
    
    /**
    ****************************************************************************
    ***  Method Name: displayCurVehicle
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** This particular Method is intended to display the current vehicle that
    *** the user is viewing. The parameter is used to access all the current
    *** vehicle's attributes.
    *** Method Inputs: int index.
    *** Return value: void.
    ****************************************************************************
    *** September 28, 2015.
    ****************************************************************************
    **/
    private void displayCurVehicle(int index)
    { 
        try
        {
            if(vehicle[index] != null)  //object at index is not empty
            {
                lblVehicleTotal.setText(displayNumberOfVehicles());
                txtVehicleSpecs.setText(String.format("Type: %s\n%s", getVehicleClass(vehicle[index]), vehicle[index].printableString()));
                //Adjust Information labels based on type of vehicle being displayed
                switch(getVehicleClass(vehicle[index]))
                {
                    case "Car":
                    { 
                        btnSell.setText("Sell Car");
                        lblTotalSpecific.setText("Total Cars : ");
                        lblTypeTotal.setText(String.format("%s", vehicle[index].getCount())); 
                        break; 
                    }
                    case "Bus":
                    { 
                        btnSell.setText("Sell Bus");
                        lblTotalSpecific.setText("Total Bus' : ");
                        lblTypeTotal.setText(String.format("%s", vehicle[index].getCount())); 
                        break; 
                    }
                    case "Boat":
                    { 
                        btnSell.setText("Sell Boat");
                        lblTotalSpecific.setText("Total Boats: ");
                        lblTypeTotal.setText(String.format("%s", vehicle[index].getCount())); 
                        break; 
                    }
                }
            }
            else
            {
                lblVehicleTotal.setText(displayNumberOfVehicles());
                lblTotalSpecific.setText("- - -");
                lblTypeTotal.setText("--"); 
                txtVehicleSpecs.setText("");
            }
        }
        catch(Exception ex)
        { lblMsg.setText(ex.getMessage()); }
        
    }
    
    /**
    ****************************************************************************
    ***  Method Name: displayNumberOfVehicles
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Iterates through the vehicle array and counts the number of objects it
    *** has.
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** September 14, 2015.
    ****************************************************************************
    **/
    private String displayNumberOfVehicles()
    { 
        int count = 0;
        for (int i = 0; i < vehicle.length; i++) 
        {
            if(vehicle[i] != null)
            { count++; }
        }
        return String.format("%s", count); 
    }
    
    /**
    ****************************************************************************
    ***  Method Name: getVehicleClass
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Determines the type of vehicle the object passed is. Car, Bus, or Boat
    *** Returns null if it is neither of the three classes.
    *** Method Inputs: Vehicle vehicle.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    private String getVehicleClass(Vehicle vehicle)
    {
            String obj = vehicle.getClass().toString();
            if(obj.endsWith("Car"))
            { return "Car"; }
            else if(obj.endsWith("Bus"))
            { return "Bus"; }
            else if(obj.endsWith("Boat"))
            { return "Boat"; }
            else
            { return null; }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: moveToNextVehicle
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Displays the next vehicle in line if the object is not empty.
    *** Displays the first vehicle if the end of the array is reached. 
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    private void moveToNextVehicle()
    { 
        try
        { 
            if(vehicle[currentVehicle + 1] != null)
            { displayCurVehicle(++currentVehicle); }
            else
            { throw new Exception(); }
        }
        //Occurs if next item in array is empty or index out of bounds
        catch(Exception ex) //set/display first Car object.
        { displayCurVehicle(currentVehicle = 0); }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: moveToPrevVehicle
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Displays the previous vehicle in line if the object is not empty.
    *** Displays the last vehicle if the beginning of the array is reached. 
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    private void moveToPrevVehicle()
    { 
        try
        { 
            if(vehicle[currentVehicle - 1] != null)
            { displayCurVehicle(--currentVehicle); } 
        }
        //Occurs if previous item in array is empty or index out of bounds
        catch(Exception ex) //set/display Car object at end of list
        { displayCurVehicle(currentVehicle = nextSpot - 1); }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: removeCurVehicle
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Moves all objects in vehicle down in the line, overwriting the current
    *** vehicle being displayed.
    *** If the last object in the array is being deleted, no objects shift, it
    *** is simply set to null
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    private void removeCurVehicle()
    {
        vehicle[currentVehicle].remove();
        for(int i = currentVehicle; i < nextSpot; i++)
        { 
            if(i == vehicle.length - 1)//simply set null if last one
            { vehicle[i] = null; }
            else if(vehicle[i + 1] != null) //Overwrite current Vehicle, move all items down one.
            { vehicle[i] = vehicle[i + 1]; }
            else
            { vehicle[i] = null; }
        }
        nextSpot--; //move down with vehicles
    }
    
    /**
    ****************************************************************************
    ***  Method Name: resetMessage
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** This particular Method is intended to reset the message to that notifies
    *** the user of any errors. It gets reset to "- - -". 
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** September 14, 2015.
    ****************************************************************************
    **/
    private void resetMessage()
    { lblMsg.setText("- - -"); }
    
    /**
    ****************************************************************************
    ***  Method Name: salesCommission
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the commission calculated, based on the customer's offer.
    *** Method Inputs: int custOffer.
    *** Return value: int.
    ****************************************************************************
    *** September 14, 2015.
    ****************************************************************************
    **/
    private int salesCommission(int custOffer)
    { return vehicle[currentVehicle].calculateCommission(custOffer); }
    
    /**
    ****************************************************************************
    ***  Method Name: setNextAvailableSpot
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Finds the end of the vehicle list by finding the first null value and
    *** sets nextSpot's value to the null value's position in the list.
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    private void setNextAvailableSpot()
    { 
        for(int i = 0; i < vehicle.length; i++)
        {
            if(vehicle[i] == null)
            { nextSpot = i; break; }    //set nextSpot and exit loop
        }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: tallyVehicleType
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Used after loading a vehicle file. Increments the count for each vehicle
    *** type that is encountered, as well as increment the total vehicle count. 
    *** Method Inputs: int startLocation.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    
    private void tallyVehicleType(int startLocation)
    {
        for (int i = startLocation; i < vehicle.length; i++) 
        { 
            if(vehicle[i] != null)
            { vehicle[i].setCount(); }
        }
    }
}

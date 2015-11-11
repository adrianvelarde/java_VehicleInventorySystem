package velarde.dealerinventory;

import java.io.Serializable;

/**
********************************************************************************
*** Class Name: Bus
*** Class Author: Adrian Velarde
********************************************************************************
*** This class is used to define the specific types of objects that will be used 
*** by the Inventory System.
*** Extends Vehicle
********************************************************************************
*** September 27, 2015.
********************************************************************************
*** List of changes with dates: No changes after completion.
********************************************************************************
**/
public class Bus extends Vehicle implements Serializable
{
    private static int busCount = 0;
    private int length;
    private int passCount;
    private boolean diesel;
    
    public Bus(int length, int passCount, boolean diesel, String make, String model, int purchasePrice, int askingPrice)
    { 
        super(make, model, purchasePrice, askingPrice);
        setLength(length);
        setPassCount(passCount);
        setDiesel(diesel);
        setCount();
    }
    
    /**
    ****************************************************************************
    ***  Method Name: getLength
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the length.
    *** Method Inputs: N/A.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public int getLength()
    { return length; }
    
    /**
    ****************************************************************************
    ***  Method Name: setLength
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of length
    *** Method Inputs: int length.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setLength(int length)
    { this.length = length; }
    
    /**
    ****************************************************************************
    ***  Method Name: getPassCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the Passenger Count.
    *** Method Inputs: N/A.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public int getPassCount()
    { return passCount; }
    
    /**
    ****************************************************************************
    ***  Method Name: setPassCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of passCount
    *** Method Inputs: int count.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setPassCount(int count)
    { this.passCount = count; }
    
    /**
    ****************************************************************************
    ***  Method Name: getDiesel
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the diesel.
    *** Method Inputs: N/A.
    *** Return value: boolean.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public boolean getDiesel()
    { return diesel; }
    
    /**
    ****************************************************************************
    ***  Method Name: setDiesel
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of diesel
    *** Method Inputs: boolean diesel.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setDiesel(boolean diesel)
    { this.diesel = diesel; }
    
    /**
    ****************************************************************************
    ***  Method Name: remove
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Decrements the value of vehCount
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** September 28, 2015.
    ****************************************************************************
    *** Changes: added super.remove() to decrement the total number of vehicles
    ****************************************************************************
    **/
    @Override
    public void remove()
    { 
        if(busCount > 0)
        { 
            busCount--; 
            super.remove();
        }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: getCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the vehicle count.
    *** Method Inputs: N/A.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    @Override
    public int getCount()
    { return busCount; }
    
    /**
    ****************************************************************************
    ***  Method Name: setCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Increments the bus count.
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    @Override
    public void setCount()
    { busCount++; }
    
    /**
    ****************************************************************************
    ***  Method Name: printableString
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the information of the vehicle as a String
    *** Method Inputs: N/A.
    *** Return value: String.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    @Override
    public String printableString()
    { return String.format("Make: %s\nModel: %s\nPassenger Count: %s\nLength: %s\nDiesel: %s\nPurchase Price: $%,2d\nAsking Price: $%,2d", getMake(), getModel(), getPassCount(), getLength(), getDiesel(), getPurchasePrice(), getAskingPrice()); }
}

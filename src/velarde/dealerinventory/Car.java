package velarde.dealerinventory;

import java.io.Serializable;

/**
********************************************************************************
*** Class Name: Car
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
public class Car extends Vehicle implements Serializable
{
    private static int carCount = 0;
    private int passCount;
    private int doorCount;
    private double mpg;
    
    public Car(int passCount, int doorCount, double mpg, String make, String model, int purchasePrice, int askingPrice)
    { 
        super(make, model, purchasePrice, askingPrice); //call to super must be first statement in constructor
        setPassCount(passCount);
        setDoorCount(doorCount);
        setMpg(mpg);
        setCount();
    }
    
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
    { passCount = count; }
    
    /**
    ****************************************************************************
    ***  Method Name: getDoorCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the doorCount.
    *** Method Inputs: N/A.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public int getDoorCount()
    { return doorCount; }
    
    /**
    ****************************************************************************
    ***  Method Name: setDoorCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of doorCount
    *** Method Inputs: int count.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setDoorCount(int count)
    { doorCount = count; }
    
    /**
    ****************************************************************************
    ***  Method Name: getMpg
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the mpg.
    *** Method Inputs: N/A.
    *** Return value: double.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public double getMpg()
    { return mpg; }
    
    /**
    ****************************************************************************
    ***  Method Name: setMpg
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of mpg
    *** Method Inputs: double mpg.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setMpg(double mpg)
    { this.mpg = mpg; }
    
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
        if(carCount > 0)
        { 
            carCount--; 
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
    { return carCount; }
    
    /**
    ****************************************************************************
    ***  Method Name: setCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Increments the car count.
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    @Override
    public void setCount()
    { carCount++; }
    
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
    { return String.format("Make: %s\nModel: %s\nPassenger Count: %s\nDoor Count: %s\nMiles Per Gallon: %s\nPurchase Price: $%,2d\nAsking Price: $%,2d", getMake(), getModel(), getPassCount(), getDoorCount(), getMpg(), getPurchasePrice(), getAskingPrice()); }
}

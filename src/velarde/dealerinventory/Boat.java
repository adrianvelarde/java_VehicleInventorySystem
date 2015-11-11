package velarde.dealerinventory;

import java.io.Serializable;

/**
********************************************************************************
*** Class Name: Boat
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
public class Boat extends Vehicle implements Serializable
{
    private static int boatCount = 0;
    private int weight;
    private int passCount;
    private int totalHP;
    
    public Boat(int weight, int passCount, int totalHP, String make, String model, int purchasePrice, int askingPrice)
    { 
        super(make, model, purchasePrice, askingPrice);
        setWeight(weight);
        setPassCount(passCount);
        setTotalHP(totalHP);
        boatCount++;
    }
    
    /**
    ****************************************************************************
    ***  Method Name: getWeight
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the weight.
    *** Method Inputs: N/A.
    *** Return value: String.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public int getWeight()
    { return weight; }
    
    /**
    ****************************************************************************
    ***  Method Name: setWeight
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of weight
    *** Method Inputs: int weight.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setWeight(int weight)
    { this.weight = weight; }
    
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
    ***  Method Name: getTotalHP
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the make.
    *** Method Inputs: N/A.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public int getTotalHP()
    { return totalHP; }
    
    /**
    ****************************************************************************
    ***  Method Name: setTotalHP
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of totalHP
    *** Method Inputs: int totalHP.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setTotalHP(int totalHP)
    { this.totalHP = totalHP; }
    
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
        if(boatCount > 0)
        { 
            boatCount--; 
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
    { return boatCount; }
    
    /**
    ****************************************************************************
    ***  Method Name: setCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Increments the boat count.
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    @Override
    public void setCount()
    { boatCount++; }
    
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
    { return String.format("Make: %s\nModel: %s\nPassenger Count: %s\nWeight: %s\nTotalHP: %s\nPurchase Price: $%,2d\nAsking Price: $%,2d", getMake(), getModel(), getPassCount(), getWeight(), getTotalHP(), getPurchasePrice(), getAskingPrice()); }
}

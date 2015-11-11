package velarde.dealerinventory;

import java.io.Serializable;

/**
********************************************************************************
*** Class Name: Vehicle
*** Class Author: Adrian Velarde
********************************************************************************
*** This class is used to define the types of objects that will be used by the
*** Inventory System.
********************************************************************************
*** September 27, 2015.
********************************************************************************
*** List of changes with dates: No changes after completion.
********************************************************************************
**/
public class Vehicle implements Serializable
{
    private static int vehCount = 0;
    private String make;
    private String model;
    private int purchasePrice;
    private int askingPrice;
    
    public Vehicle(String make, String model, int purchasePrice, int askingPrice)
    { 
        setMake(make);
        setModel(model);
        setPurchasePrice(purchasePrice);
        setAskingPrice(askingPrice);
        vehCount++;
    }
    
    /**
    ****************************************************************************
    ***  Method Name: getMake
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the make.
    *** Method Inputs: N/A.
    *** Return value: String.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public String getMake()
    { return make; }
    
    /**
    ****************************************************************************
    ***  Method Name: setMake
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of make
    *** Method Inputs: String make.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setMake(String make)
    { this.make = make; }
    
    /**
    ****************************************************************************
    ***  Method Name: getModel
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the model.
    *** Method Inputs: N/A.
    *** Return value: String.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public String getModel()
    { return model; }
    
    /**
    ****************************************************************************
    ***  Method Name: setModel
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of model
    *** Method Inputs: String model.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setModel(String model)
    { this.model = model; }
    
    /**
    ****************************************************************************
    ***  Method Name: getPurchasePrice
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the purchasePrice.
    *** Method Inputs: N/A.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public int getPurchasePrice()
    { return purchasePrice; }
    
    /**
    ****************************************************************************
    ***  Method Name: setPurchasePrice
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of purchasePrive
    *** Method Inputs: int price.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setPurchasePrice(int price)
    { this.purchasePrice = price; }
    
    /**
    ****************************************************************************
    ***  Method Name: getAskingPrice
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Returns the askingPrice.
    *** Method Inputs: N/A.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public int getAskingPrice()
    { return askingPrice; }
    
    /**
    ****************************************************************************
    ***  Method Name: setAskingPrice
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Sets the value of askingPrice
    *** Method Inputs: int price.
    *** Return value: void.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public void setAskingPrice(int price)
    { this.askingPrice = price; }
    
    /**
    ****************************************************************************
    ***  Method Name: deal
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Determines if the customer's offer is good enough for a deal.
    *** Method Inputs: int index.
    *** Return value: void.
    ****************************************************************************
    *** September 28, 2015.
    ****************************************************************************
    **/
    public boolean deal(int custOffer)
    { 
        if(custOffer >= getPurchasePrice())
        { return true; }
        return false;
    }
    
    /**
    ****************************************************************************
    ***  Method Name: remove
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Decrements the value of vehCount (the total number of vehicles)
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** September 28, 2015.
    ****************************************************************************
    **/
    public void remove()
    { 
        if(vehCount > 0)
        { vehCount--; } 
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
    public int getCount()
    { return vehCount; }
    
    /**
    ****************************************************************************
    ***  Method Name: setCount
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Increments the vehicle count.
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    public void setCount()
    { vehCount++; }
    
    /**
    ****************************************************************************
    ***  Method Name: calculateCommission
    *** Method Author: Adrian Velarde
    ****************************************************************************
    *** Commission is calculated by subtracting the purchase price from the
    *** customer offer to get the profit. Then ~20% of the profit is returned.
    *** Method Inputs: int custOffer.
    *** Return value: int.
    ****************************************************************************
    *** September 27, 2015.
    ****************************************************************************
    **/
    public int calculateCommission(int custOffer)
    { return (int)((custOffer - getPurchasePrice()) * 0.2); }
    
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
    public String printableString()
    { return ""; }
}

package velarde.dealerinventory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;

/**
********************************************************************************
*** Class Name: ReadWrite
*** Class Author: Adrian Velarde
********************************************************************************
*** This class is used to Read objects from a serialized (.ser) file and Write
*** objects to a serialized file. Make sure to include the .ser file extension.
********************************************************************************
*** November 1, 2015.
********************************************************************************
*** List of changes with dates: No changes after completion.
********************************************************************************
**/
public class ReadWrite 
{
    private File fileName;
    private ObjectOutputStream output; //output to file
    private ObjectInputStream input;   //input to program
    
    /**
    ****************************************************************************
    ***  Method Name: getFileName
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Allows the user to select a file to read from or write to. The 'open'
    *** parameter determines whether an open or save dialog box will appear.
    *** Return a boolean to allow the UI to determine if the 
    *** Method Inputs: boolean.
    *** Return value: boolean.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    public boolean getFileName(boolean open)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int option;
        
        if(open == true)    //read
        { option = chooser.showOpenDialog(chooser); }
        else    //write
        { option = chooser.showSaveDialog(chooser); }
        
        if(option != JFileChooser.CANCEL_OPTION && chooser.getSelectedFile().toString().endsWith(".ser"))
        { fileName = chooser.getSelectedFile(); }
        else
        { return false; }
        return true;
    }
    
    /**
    ****************************************************************************
    ***  Method Name: openWriter
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Creates a new ObjectOutputStream from the given file name
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    public void openWriter()
    {
        try
        { output = new ObjectOutputStream(new FileOutputStream(fileName)); }
        catch(Exception ex)
        { }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: openReader
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Creates a new ObjectInputStream from the given file name
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    public void openReader()
    {
        try
        { input = new ObjectInputStream(new FileInputStream(fileName)); }
        catch(Exception ex)
        { }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: write
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Writes a Vehicle object to the file
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    public void write(Vehicle vehicle)
    {
        try
        { output.writeObject(vehicle); }
        catch(Exception ex)
        { }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: read
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Reads an object from the file
    *** Method Inputs: N/A.
    *** Return value: Object.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    public Object read()
    {
        //null so can return it when there's no more objects to read
        Object tmp = null;    
        try
        { tmp = input.readObject(); }
        catch(Exception ex)
        { }
        return tmp;
    }
    
    /**
    ****************************************************************************
    ***  Method Name: closeWriter
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Closes the ObjectInputStream
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    public void closeWriter()
    {
        try
        { output.close(); }
        catch(Exception ex)
        { }
    }
    
    /**
    ****************************************************************************
    ***  Method Name: closeReader
    ***  Method Author: Adrian Velarde
    ****************************************************************************
    *** Closes the ObjectInputStream
    *** Method Inputs: N/A.
    *** Return value: void.
    ****************************************************************************
    *** November 1, 2015.
    ****************************************************************************
    **/
    public void closeReader()
    {
        try
        { input.close(); }
        catch(Exception ex)
        { }
    }
}

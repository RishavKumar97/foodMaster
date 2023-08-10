package com.foodMaster.Controller;

/*
 * PMVWPropertyReader.java
 *
 * Created on January 30, 2006, 10:20 AM
 */


/* The imports */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * The super class for the property reader classes in the code compete application.
 *
 * @author kallol
 */
public class DBConfigReader {

    /**
     * The member variable that holds the values read from the properties file
     */

    private Properties valuesList = null;
    /**
     * Holds the only instance of this class
     */
    private static DBConfigReader theInstance = null;
    private static DBConfigReader theInstanceMask = null;
    /**
     * Creates a new instance of PMVWPropertyReader
     *
     * @param fileName The name of the property file to be loaded.
     */
    protected DBConfigReader(String fileName) {

        try {

            /* Get the properties */
            if (valuesList == null) {

                valuesList = new Properties();

                /* Load the properties */
                InputStream inStrm = new FileInputStream(fileName);

                valuesList.load(inStrm);

                inStrm.close();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static DBConfigReader getInstance() {
        
        if (theInstance == null) {
            
            theInstance = new DBConfigReader(DBPropertyReader.getInstance().getProperty("config_file"));
        }
        
        return theInstance;
    }


    /**
     * The method that returns a property value given the property name
     *
     * @param name The name of the property for which the value is desired
     * @return The property as a string, null if the name is not valid.
     */
    public String getProperty(String name) {

        if (name != null && valuesList != null) {

            return (valuesList.getProperty(name));
        } else {

            return (null);
        }
    }

    /**
     * The method that returns all the property names.
     *
     * @return An enumeration of all property names.
     */
    public Enumeration getPropertyNames() {

        if (valuesList != null) {

            return (valuesList.propertyNames());
        } else {

            return (null);
        }
    }
    
    /**
     * Method to add an additional property name
     */
    public synchronized void setProperty(String name, String value) {
        
        if(valuesList != null) {
            
            valuesList.setProperty(name, value);
        }
    }
}


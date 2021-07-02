package com.isep.gorgeoussandwich.utils;

import java.io.IOException;
import java.util.Properties;

import com.isep.gorgeoussandwich.GorgeoussandwichApplication;



public class PropertiesObtain {

    /**
     *
     * @return
     * @throws IOException
     */
    public static Properties getProperties()  {
        Properties props = new Properties();
        try {
            props.load(GorgeoussandwichApplication.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return props;
    }

    public static String getPropertiesValue(String key)  {
        Properties props = PropertiesObtain.getProperties();
        return props.getProperty(key);
    }
}


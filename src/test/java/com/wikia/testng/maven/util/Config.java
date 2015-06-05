package com.wikia.testng.maven.util;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private Properties properties;

    public Config(String env) throws Exception {
        this.properties = new Config().getProperties();

        if (env != null)
        {
            Properties environment = new Properties();
            InputStream is = this.getClass().getResourceAsStream("/config/" + env + ".properties");

            if (is != null)
            {
                environment.load(is);
                is.close();

                properties.putAll(environment);
                properties.putAll(System.getProperties());
            }
            else
            {
                System.out.println("Environment file for " + env + " does not exist!");
            }
        }
    }

    public Config() throws Exception {

        Properties defaults = new Properties();
        InputStream is = this.getClass().getResourceAsStream("/config/default.properties");
        if (is != null)
        {
            defaults.load(is);
            is.close();

            properties = new Properties();
            properties.putAll(defaults);
        }
        properties.putAll(System.getProperties());
    }

    public Properties getProperties()
    {
        return this.properties;
    }

    public void setProperties(Properties p)
    {
        this.properties = p;
    }

    public String getProperty(String name)
    {
        return properties.getProperty(name);
    }

    public String getProperty(String name, String defaultValue)
    {
        return properties.getProperty(name, defaultValue);
    }
}


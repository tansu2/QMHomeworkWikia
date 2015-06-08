package com.wikia.testng.maven.util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class LogInitializer extends Properties {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogInitializer() throws IOException {
        URL file = this.getClass().getResource("/logging/log4j.properties");
        if (file != null) {
            this.load(file.openStream());
        }
    }
}
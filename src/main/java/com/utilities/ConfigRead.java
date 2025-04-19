package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {
	public static Properties prop;

	public static Properties config() {
		if (prop == null) {
			try {
				prop = new Properties();
				FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
				prop.load(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
}

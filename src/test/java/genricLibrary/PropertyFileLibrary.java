package genricLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary {

	public String fetchDataFromPropertyFile(String key) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(IConstatntPath.PROPERTIES_FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties property = new Properties();

		try {
			property.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		String value = property.getProperty(key);
		return value;

	}

}

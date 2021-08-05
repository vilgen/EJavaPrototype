package com.ericsson.java.prototype.io;

import java.io.*;
import java.util.Properties;

public class WriteFile {

	public void writeAppConfDataToAppProperties(String data_file_path, String cron_expression) {

		Properties prop = new Properties();
		String propFileName = "app.properties";

		try {
			InputStream inputStream = new FileInputStream(propFileName);//getClass().getClassLoader().getResourceAsStream(propFileName);

			prop.load(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

		prop.setProperty("data.file.path", data_file_path);
		prop.setProperty("cron.expression", cron_expression);

		try {
			FileOutputStream outputstream = new FileOutputStream(propFileName);
			prop.store(outputstream, null);
			outputstream.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

//	private File createPropertiesFile(String relativeFilePath) throws URISyntaxException {
//		return new File(new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()),
//				relativeFilePath);
//	}

	public void writeJsonDataToFile(String dataFilePath, String dataJson) {

		try {
			// get or create the file
			File f = new File(dataFilePath);
			BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(f));
			bf.write(dataJson.getBytes());
			bf.flush();
			bf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.ericsson.java.prototype.io;

import java.io.*;

public class WriteFile {

	public void writeAppConfDataToLocale(String data_file_path, String cron_expression) {
		
		try {

			String data = "data_file_path=" + data_file_path + "\n" + "scheduler=" + cron_expression;

			// get or create the file
			File f = new File("src/main/resources/app.properties");
			BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(f));
			bf.write(data.getBytes());
			bf.flush();
			bf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

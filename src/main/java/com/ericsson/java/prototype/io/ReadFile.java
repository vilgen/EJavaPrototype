package com.ericsson.java.prototype.io;

import java.io.*;

public class ReadFile {
	
	private String app_conf_content;

	public String getApp_conf_content() {
		return app_conf_content;
	}

	public void setApp_conf_content(String app_conf_content) {
		this.app_conf_content = app_conf_content;
	}

	// Reads the app.conf file from PC and set the content
	public void readConfFile() {

		File f = new File("C:\\ericsson-java-prototype\\conf\\app.conf");
		byte[] array = new byte[1024];

		try {
			FileInputStream file = new FileInputStream(f);
			BufferedInputStream bf = new BufferedInputStream(file);

			int read = 0;

			while ((read = bf.read(array)) != -1) {
				String data = new String(array, 0, read);
				setApp_conf_content(data);
			}

			bf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read the data.json file from PC and return the content
	public String readDataFile(String path) {
				
		File f = new File(path);
		
		/*create new data file if it is not there*/
		if(!f.isFile()) {
			
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		byte[] array = new byte[1024];
		String dataJson = "";

		try {
			FileInputStream file = new FileInputStream(f);
			BufferedInputStream bf = new BufferedInputStream(file);

			int read = 0;

			while ((read = bf.read(array)) != -1) {
				String data = new String(array, 0, read);
				dataJson = data;
			}

			bf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return dataJson;

	}
	
//	Reads the app.conf file from project base-dir and return data_file_path 
	public String readAppPropFile() {

		File f = new File("src/main/resources/app.properties");
		byte[] array = new byte[1024];
		String value = "";

		try {
			FileInputStream file = new FileInputStream(f);
			BufferedInputStream bf = new BufferedInputStream(file);

			int read = 0;

			while ((read = bf.read(array)) != -1) {
				String data = new String(array, 0, read);
				value = data;
			}

			bf.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;

	}
}

package common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

	public  Properties prop = new Properties();

	public PropertiesFile(String fileName) 
	{
		File file = new File(System.getProperty("user.dir")+"/src/ObjectRepo/"+fileName);

		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public String getProp(String Key)
	{
		String value =(String) prop.get(Key);
		return value;
	}
}

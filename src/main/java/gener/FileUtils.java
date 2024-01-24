package gener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {  
	/**
	 * This method is used to read data from property file
	 * @author HP
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;  
	}
	
	/**
	 * This method is used to write data into Excel file
	 * @author HP
	 * @param userName
	 * @param password
	 * @throws IOException
	 */
	
	public void writeData(String userName,String password) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		Properties p=new Properties();
		
		p.setProperty(userName, password);
		FileOutputStream fos=new FileOutputStream(IPathConstants.FilePath);
		p.store(fos,"write data");
	}

	/*public static void copyFile(File dest) {
		// TODO Auto-generated method stub
		
	}*/

}

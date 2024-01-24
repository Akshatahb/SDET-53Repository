package gener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {  //IPathConstants
	
	public int getRandomNo()
	{
		Random ran=new Random();
		int count = ran.nextInt(100);
		return count;
	}

	public String getSystemDate()
	{
		Date dt=new Date();
		String date=dt.toString();
		return date;
	} 
	
	public String getSystemDateFormat()
	{
		SimpleDateFormat   dateformat=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		
		Date dt=new Date();
		//String date=dt.toString();
	
		String SystemDateFormat=dateformat.format(dt);
		return SystemDateFormat;
	}
}
  
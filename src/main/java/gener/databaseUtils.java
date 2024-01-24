package gener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class databaseUtils {
	
	Connection con=null;
	/**
	 * 
	 * @throws SQLException
	 */
	
	public void registerConnection() throws SQLException
	{
		 Driver driver=new Driver();   
		 DriverManager.registerDriver(driver);
		 con=DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUsername, IPathConstants.DBPassword);
	}
	   
	/**
	 * 
	 * @param query
	 * @param colNum
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	
	public String executeQueryAndGetData(String query, int colNum,String expData) throws SQLException 
	{
	  String data=null;
	  boolean flag=false;
	  
	  Statement state=con.createStatement();  
	  ResultSet result = state.executeQuery(query);  
	  
	  while(result.next())
	  {
		  data=result.getString(colNum);
		  if(data.equalsIgnoreCase(expData))
		  {
			  flag=true;
			  break;
		  }
	  }
	  
	  if(flag)
	  {
		  System.out.println(data +" ====data verified========= ");
		  return expData;
	  }
	  else
	  {
		  System.out.println(" =====data not verified====== ");
		  return "";
	  }
	}
	
	// close connection 
	public void closeConnection() throws SQLException
	{
		con.close();
	}
}
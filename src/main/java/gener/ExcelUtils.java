package gener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	/**
	 * This method is used to read data from application 
	 * @author HP
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelData(String sheetName, int rowNo, int cellNo ) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to get last row number
	 * @author HP
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		return count;
	}
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastCellNum(String sheetName,int row) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int cellCount=sh.getRow(row).getLastCellNum();
		return cellCount;
	}
	
	
	/**
	 * This method is used to get data from HashMap
	 * @param sheetName
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public HashMap<String, String> hashMapData(String sheetName, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int lastRowNum = sh.getLastRowNum();
		
		HashMap<String, String>map=new HashMap<String, String>();
		
		for(int i=0;i<=lastRowNum;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(cell).getStringCellValue();
			map.put(key, value);
		}
		return map;
		
	}
	
	/**
	 * This method is used to write data into Excel sheet
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writeDataToExcel(String sheetName,int row,int cell,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fOut=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fOut);
		wb.close();
	}
	
	
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
		
	public void setExcelData(String sheetName,String value,int rowNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		wb.getSheet(sheetName).getLastRowNum();
		Sheet sh=wb.getSheet(sheetName);
		
		for(int i=1;true;i++)
		{
			try
			{
				Row row=sh.getRow(rowNum);
				Cell cel=row.getCell(i);
				if(cel==null)
				{
					row.createCell(i).setCellValue(value);
					break;
				}
			}catch(Exception e)
			{
				
			}
		}
		
		FileOutputStream fOut=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fOut);
		wb.close();
	}
	
	public void setExcelData(String sheetname,String value, int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.getRow(row).getCell(cell).setCellValue(value);    
		FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	
	
	/*public void setExcelData(String sheetName,int cell, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		wb.getSheet(sheetName).getLastRowNum();
		Sheet sh=wb.getSheet(sheetName);
		
		for(int i=0;true;i++)
		{
			try
			{
				Cell cel=sh.getRow(i).getCell(cell);
				if(cel!=null)
				{
					sh.createRow(i+1).createCell(cell).setCellValue(value);
					break;
				}
			}catch(Exception e)
			{
				
			}
		}
		FileOutputStream fOut=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fOut);
		wb.close();
	}*/
	
	/**
	 * 
	 * @param sheetName
	 * @param value
	 * @param rowNum
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setHashData(String sheetName, String value,int rowNum) throws EncryptedDocumentException, IOException
    {
      FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
      Workbook wb=WorkbookFactory.create(fis);
      wb.getSheet(sheetName).getLastRowNum();
      Sheet sh=wb.getSheet(sheetName);
      
      for(int i=1;true;i++)
      {
    	  try
    	  {
    		Row row=sh.getRow(rowNum);
    		Cell cell=row.getCell(i);
    		
    		if(cell==null)
    		{
    			row.createCell(i).setCellValue(value);
    			break;
    		}
    		
    	  }catch(Exception e)
    	  {
    		  
    	  }
      }
      
      
      
      FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
      wb.write(fos);
      wb.close();
    		  
    }
	/**
	 * 
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleSetOfData(String sheetName) throws Throwable
	{
		FileInputStream fis =new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum()+1;
		int lastCel=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)             //Row
		{
			for(int j=0;j<lastCel;j++)        //column
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
	}

}

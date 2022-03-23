package Testutils.LmsApi;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.format.CellGeneralFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	public class XLutils{
		
		
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public CellStyle style;   
	static String path=null;

	public XLutils(String path) {
		XLutils.path=path;
	}

	public int getRowCount(String sheetName) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;		
	}


	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}


	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); 
		//Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	  
	
	
	public Object[][] getExcelData(String fileName, String sheetName){
        	
        Object[][] data = null;   	
 	   	
	   			
        try {
        	
  	    fi = new FileInputStream(path);
  	    workbook=new XSSFWorkbook(fi);
  		sheet=workbook.getSheet(sheetName);
   	   	XSSFRow row = sheet.getRow(0);
   	   	
   	   	int totalrows = sheet.getLastRowNum(); // no. of rows
   	   	System.out.println("Total no. of rows is  "  +totalrows );
  	 
   	   	int totalcols= sheet.getRow(0).getLastCellNum();// number of cells in a row =no. of columns in the table
   	   	System.out.println("Total no. of cols is  "  +totalcols); 
  	  	
  	   	Cell cell;
  	   data = new Object[totalrows][totalcols];
  	   	
  	   	for(int i =1; i<=totalrows;i++){
			 row = sheet.getRow(i);// reading rows 

  	   		for(int j=0;j<totalcols;j++){
  		    	   				 	
  		    	cell= row.getCell(j);
  		    	
  		    	
  		    		
  		 DataFormatter formatter = new DataFormatter();
  		data[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j)); 
	  			
  		 // data[i-1][j] = cell.getStringCellValue();
 		//Returns the formatted value of a cell as a String regardless of the cell type.
					}
  	   			}
  	   	   }
  	   			
        	catch (Exception e) {
	     	   
        		System.out.println("The exception is: " + e.getMessage());
  	   			
        		}
     				return data;
		 	}
		
		} 					
		 		




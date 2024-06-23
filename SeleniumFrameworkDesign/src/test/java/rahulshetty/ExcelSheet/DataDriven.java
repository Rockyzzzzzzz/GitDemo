package rahulshetty.ExcelSheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataDriven 
{

	public ArrayList<String> getData(String testcaseName) throws IOException 
	
	{
		
	   ArrayList<String> a=new ArrayList<String>();
		
       FileInputStream fis=new FileInputStream("D:\\ExcelSheet\\demodata.xlsx");
       XSSFWorkbook workbook= new XSSFWorkbook(fis);
       int noOfSheets= workbook.getNumberOfSheets();
       for(int i=0;i<noOfSheets;i++)
       {
    	   if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
    	   {
    		   XSSFSheet sheet= workbook.getSheetAt(i);
    		   //Identify testcases column by scanning the entire 1st row
    		    Iterator<Row> rows= sheet.rowIterator(); //sheet is collection of rows
    		    Row firstRow= rows.next();
    		    Iterator<Cell> cells= firstRow.cellIterator(); // row is collection of cells
    		    int k=0;
    		    int coloumn=0;
    		    while(cells.hasNext())
    		    {
    		    	Cell value= cells.next();
    		    	if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
    		    	{
    		    		//desired column
    		    		coloumn=k;
    		    	}
    		    	
    		    	k++;
    		    	
    		    }
    		   
    		   
    		   System.out.println(coloumn);
    		   
    		   //once column is identified then scan entire testcase column to identify purchase testcase row
    		   while(rows.hasNext())
    		   {
    			   Row r= rows.next();
    			   if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))     //testcasename = purchase ,Add profile
    			   {
    				   //after you grab purchase testcase row put all the data of tht row and feed into test
    				   Iterator<Cell> cv= r.cellIterator(); // row is collection of cells
    	    		    while(cv.hasNext())
    	    		    {
    	    		    	Cell c= cv.next();
    	    		    	if(c.getCellType()==CellType.STRING)
    	    		    	{
    	    		    		 //System.out.println(cv.next().getStringCellValue());
        	    		    	 a.add(c.getStringCellValue());
    	    		    	}
    	    		    	else
    	    		    	{
    	    		    		
    	    		    		a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
    	    		    	}
    	    		      
    	    		    	
    	    		    }
    			   }
    		   }
    		   
           }
    	     
    	   
    	   
       }
       
      

       return a;
       
	}
	
}

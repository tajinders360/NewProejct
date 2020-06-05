package com.practice.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	
	static void readExcel(String fileName) throws IOException
	{
		
	   Workbook wb= WorkbookFactory.create(new FileInputStream(fileName));
		
	   Sheet sh= wb.getSheet("Records");
	   
	   int rowCount = sh.getPhysicalNumberOfRows();
	   
	   System.out.println("Row count is : " +rowCount);
	   
	   for(int i=0;i<rowCount;i++)
	   {
		   Row r= sh.getRow(i);
		   
		   //int colCount = r.getPhysicalNumberOfCells();
		   
		  // System.out.println("Col count is : " +colCount);
		   
		   for(int j=0;j< r.getLastCellNum();j++)
		   {
			   DataFormatter dataFormatt= new DataFormatter();
			  
			  // Cell c =r.getCell(j);
		   	   
		      //String data= c.getStringCellValue();
		      
		      
		      System.out.print(dataFormatt.formatCellValue(r.getCell(j))+ " \t");
		   }
		   System.out.println();
	   }
	   
	   
	}
	
	public static void main(String[] args) throws IOException {
		readExcel("E:\\New folder\\com.test.firstProject\\Data\\TestData.xlsx");
	}

}

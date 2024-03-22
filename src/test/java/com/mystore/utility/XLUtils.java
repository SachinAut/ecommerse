package com.mystore.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String Xlfile,String xlSheet)throws IOException
	{
		
		fi=new FileInputStream(Xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		
		return rowcount;
		
	}
	public static int getCellCount(String Xlfile,String xlSheet,int rownum)throws IOException
	{
		
		fi=new FileInputStream(Xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		
		return cellcount;
		
	}
	
	public static String getCellData(String Xlfile,String xlSheet,int rownum,int colnum)throws IOException
	{
		fi=new FileInputStream(Xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter format=new DataFormatter();
			String cellData=format.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data="";
		}
		
		wb.close();
		fi.close();
		return data;
		
	}
	
	
	

}

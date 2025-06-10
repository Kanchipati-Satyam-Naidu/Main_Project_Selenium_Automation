package app.vercel.devProfileEight.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readingdata{
	//static Properties prop;

	public static String[][] readExcelData () throws IOException {
		//prop =Loadproperties.loadProps();
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testData.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet  sheet=workbook.getSheet("Sheet1");  
		
		int totalRows=sheet.getLastRowNum();
		
		int totalCells=sheet.getRow(0).getLastCellNum()-1;
		
		String data[][] = new String[totalRows][totalCells];
			
		for(int r=0; r<totalRows; r++) { 
	        XSSFRow currentRow = sheet.getRow(r+1);
	        if (currentRow != null) {
	            for(int c=0; c<totalCells; c++) {
	                XSSFCell cell = currentRow.getCell(c);
	                DataFormatter df = new DataFormatter();
	                data[r][c] = df.formatCellValue(cell);
	            }
	        } else {
	            
	            for(int c=0; c<totalCells-1; c++) {
	                data[r][c] = "";
	            }
	        }
	    }
		
		workbook.close();
		file.close();
		return data;
		
	}
	
	
	public static String[][] readExcel() throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testData.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet  sheet=workbook.getSheet("Sheet1");  
		
		int totalRows=15;
		
		int totalCells=sheet.getRow(1).getLastCellNum()-1;
		
		String data[][] = new String[totalRows][totalCells];
		DataFormatter df = new DataFormatter();
		for(int r=0; r<totalRows; r++) { 
	        XSSFRow currentRow = sheet.getRow(r+1);
	        if (currentRow != null) {
	            for(int c=0; c<totalCells; c++) {
	                XSSFCell cell = currentRow.getCell(c);
	                
	                data[r][c] = df.formatCellValue(cell);
	            }
	        } else {
	            
	            for(int c=0; c<totalCells-1; c++) {
	                data[r][c] = "";
	            }
	        }
	    }
		
		workbook.close();
		file.close();
		return data;
	}
	
	public static String[][] readData(int row,int col) throws IOException{
		String data[][]=new String[row-21][1];
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testData2.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet  sheet=workbook.getSheet("Sheet1");
		int j=0;
		DataFormatter df = new DataFormatter();
		for(int i=21;i<row;i++) {
			XSSFCell cell=sheet.getRow(i).getCell(col);
			data[j][0]=df.formatCellValue(cell);
			j++;
		}
		return data;
	}
	
	
	
//	public static void main(String[] args) throws IOException{
//		String[][] data=readData(25,0);
//		for(String[] a:data) {
//			System.out.println(Arrays.toString(a));
//		}
//	}
}

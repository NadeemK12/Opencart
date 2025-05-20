package utilities;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	
	//Excel file --> Workbook --> sheets --> Rows --> cells
	
	//FileInputStream --> reading
	//FileOutputStream --> write		
	//XSSFWorkbook -- workbook
	//XSSFSheet
	//XSSFRow
	//XSSFCell
	
			public FileInputStream fi;
			public FileOutputStream fo;
			public XSSFWorkbook wb;
			public XSSFSheet sheet;
			public XSSFRow row;
			public XSSFCell cell;
			String path;
			public CellStyle style;
			
			public ExcelUtilities(String path) {
				this.path = path;
				
			}
			
			
			public int rowCount(String sheetName) throws IOException {
				
				fi = new FileInputStream(path);
				wb = new XSSFWorkbook(fi);
				sheet = wb.getSheet(sheetName);
				int rowcount = sheet.getLastRowNum();
				wb.close();
				fi.close();
				return rowcount;
				
				
				
			}
			
		public int cellCount( String sheetName, int rownum) throws IOException {
			
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(rownum);
			
			int cellcount = row.getLastCellNum();
			
			wb.close();
			fi.close();
			return cellcount;
			
		}
		
		
		public String getCellData(String sheetName, int rownum, int col) throws IOException {
			
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell = row.getCell(col);
			
			DataFormatter df = new DataFormatter();
			String data;
			
			try {
				
				data = df.formatCellValue(cell);
			}
			catch (Exception e){
				
				data= "";
				
				
				
			}
			wb.close();
			fi.close();
			return data;
			
		}

		
		public void setCellData(String sheetName, int rownum, int col, String data) throws IOException {
			
			File xlfile = new File(path);
			
			if(!xlfile.exists()) {
				wb = new XSSFWorkbook();
				fo = new FileOutputStream(path);
				wb.write(fo);
				
				
			}
			
			fi = new FileInputStream(path);
			wb= new XSSFWorkbook(fi);
			
			if(wb.getSheetIndex(sheetName) == -1) {
				
				wb.createSheet(sheetName);
			}
				sheet = wb.getSheet(sheetName);
			
		
			if(sheet.getRow(rownum)==null) {
				
				sheet.createRow(rownum);
			}
				
			row = sheet.getRow(rownum);
			cell =row.createCell(col);
			cell.setCellValue(data);
			fo = new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
		
		}
		
		
		
		public void fillRedColour(String sheetName, int rownum, int col) throws IOException {
			fi = new FileInputStream(path);
			wb= new XSSFWorkbook(fi);
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell =row.getCell(col);
			style = wb.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
			
			
			
		}
		
		public void fillGreenColour(String sheetName, int rownum, int col) throws IOException {
			fi = new FileInputStream(path);
			wb= new XSSFWorkbook(fi);
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell =row.getCell(col);
			style = wb.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
			
			
			
		}
	}

	
	
	


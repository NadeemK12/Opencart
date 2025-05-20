package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	
	public String [][] getData() throws IOException {
		
		
		String path = ".\\testData\\DataDrivenTestingfile.xlsx";
		
		System.out.println("able to read the sheet");
		ExcelUtilities xlu = new ExcelUtilities(path);
	int totalrows = xlu.rowCount("Sheet1");
	int totalcols = xlu.cellCount("Sheet1", 1);
	System.out.println(totalrows);
	System.out.println(totalcols);
	String loginData[][] = new String[totalrows][totalcols];
	
	for(int i=1; i<=totalrows; i++) {
		
		for(int j=0; j<totalcols; j++ ) {
			 
			
			loginData[i-1][j] = xlu.getCellData("Sheet1",i, j);
			
			System.out.println("value are reading");
		}
		
		
	}
	
	return loginData;
	}
	

}

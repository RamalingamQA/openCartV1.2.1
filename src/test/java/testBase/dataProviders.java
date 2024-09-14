package testBase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;

public class dataProviders {
	@DataProvider(name="LoginData")
	public String[][] dataProvider() throws IOException{
		String path=".\\testData\\loginTestData.xlsx";
		ExcelUtils eu=new ExcelUtils(path);
		//get row count and col count
		int totRow=eu.rowCount(path, "Sheet1");
		int totCol=eu.colCount(path, "Sheet1", 1);
		
		//create a 2D array called logincred to store the data from excel to logincred
		
		String logCred[][]=new String[totRow][totCol];
		
		//now assign the data from that excel sheet to 2d array
		
		for(int r=1;r<=totRow;r++) {
			for(int c=0;c<totCol;c++) {
				logCred[r-1][c]=eu.getCellData(path, "Sheet1", r, c);
			}
		}
		return logCred;
		
		
	}
		
}
	

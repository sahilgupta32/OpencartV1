package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility exclutil=new ExcelUtility(path);
		
		int totalrows=exclutil.getRowCount("Sheet1");
		int totalcols=exclutil.getCellCount("Sheet1", 1);
		
	String loginData[][]=new String[totalrows][totalcols];
	
	for(int i=1; i<=totalrows; i++) {
		for(int j=0; j<totalcols; j++) {
			loginData[i-1][j]=exclutil.getCellData("Sheet1", i, j);
		}
	}
	
	return loginData;
		
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4	

}

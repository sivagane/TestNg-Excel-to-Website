package org.test;

import com.Excel.Utility.Xls_Reader;

public class ExcelOperations {
public static void main(String[] args) {
	Xls_Reader reader=new Xls_Reader("C:\\Users\\jegan\\eclipse-workspace\\Excel to Website\\src\\org\\Excelsheet\\siva1.xlsx");
    
     
     if(!reader.isSheetExist("Ganesh")) {
    	 reader.addSheet("Ganesh");
     }
     
     
     
}
}

package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Excel.Utility.Xls_Reader;

public class WebtabletoExcel {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\jegan\\eclipse-workspace\\Excel to Website\\div\\chromedriver.exe");
	WebDriver d=new ChromeDriver();
	d.get("https://www.w3schools.com/html/html_tables.asp");
	
	//*[@id="customers"]/tbody/tr[2]/td[1]
	//*[@id="customers"]/tbody/tr[3]/td[1]
	//*[@id="customers"]/tbody/tr[4]/td[1]
	//*[@id="customers"]/tbody/tr[3]/td[1]
	//*[@id="customers"]/tbody/tr[7]/td[1]
	//*[@id="customers"]/tbody/tr[2]/td[2]
	
	//*[@id="customers"]/tbody/tr[2]/td[2]
	//*[@id="customers"]/tbody/tr[3]/td[2]
	//*[@id="customers"]/tbody/tr[7]/td[2]
	
	
	String beforeXpath_company="//*[@id='customers']/tbody/tr[";
	String afterXpath_company="]/td[1]";
	
	String beforeXpath_contact="//*[@id='customers']/tbody/tr[";
	String afterXpath_contact="]/td[2]";
	
	List<WebElement> row = d.findElements(By.xpath("//table[@id='customers']//tr"));
	System.out.println("The Number of Rows "+row.size());
	int rows = row.size();
	Xls_Reader reader=new Xls_Reader("C:\\Users\\jegan\\eclipse-workspace\\Excel to Website\\src\\org\\Excelsheet\\siva1.xlsx");
	if(!reader.isSheetExist("Page")) {
		reader.addSheet("Page");
		reader.addColumn("Page", "Companyname");
		reader.addColumn("Page", "Contactname");
	}
	
	for(int i=2;i<=rows;i++) {
		String actualXpath_comapany = beforeXpath_company+i+afterXpath_company;
		String company = d.findElement(By.xpath(actualXpath_comapany)).getText();
		System.out.println(company);
	    reader.setCellData("Page", "Companyname", i, company);
	    Thread.sleep(3000);
	    String actualXpath_contact = beforeXpath_contact+i+afterXpath_contact;
	    String contact = d.findElement(By.xpath(actualXpath_contact)).getText();
	    System.out.println(contact);
	    Thread.sleep(3000);
	    reader.setCellData("Page", "Contactname", i, contact);
	}
	
}
}

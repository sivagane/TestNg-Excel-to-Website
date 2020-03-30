package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Excel.Utility.Xls_Reader;

public class Datadriven {
	
	public static void main(String[] args) {
	Xls_Reader reader=new Xls_Reader("C:\\Users\\jegan\\eclipse-workspace\\Excel to Website\\src\\org\\Excelsheet\\siva1.xlsx");
	int rowCount = reader.getRowCount("Details");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jegan\\eclipse-workspace\\Excel to Website\\div\\chromedriver.exe");
	WebDriver d=new ChromeDriver();
	d.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
	reader.addColumn("Details", "Status");
	for(int rowNum=2;rowNum<=rowCount;rowNum++) {
		
	String firstname = reader.getCellData("Details", "Firstname",rowNum );
	System.out.println(firstname);
	
	String lastname = reader.getCellData("Details", "Lastname", rowNum);
	System.out.println(lastname);
	
	String Emailaddress = reader.getCellData("Details", "Emailaddress", rowNum);
	System.out.println(Emailaddress);
	
	
	
	
	d.findElement(By.id("firstName")).clear();
	d.findElement(By.id("firstName")).sendKeys(firstname);
	
	
	d.findElement(By.id("lastName")).clear();
	d.findElement(By.id("lastName")).sendKeys(lastname);
	
	
	d.findElement(By.id("username")).clear();
	d.findElement(By.id("username")).sendKeys(Emailaddress);
	
	d.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
	reader.setCellData("Details", "Status", rowNum, "pass");
	}
	}
}

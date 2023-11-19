package TestCasePackage;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import FirstPackage.BaseClass;
import UtilityPackage.WriteExcel;

public class BigBasket extends BaseClass {
	
	String filePath ="./ExternalFiles/ExcelRead.xlsx";
	
	@Test
	public void openBigBasket() throws Exception {
	
	driver.get("https://www.bigbasket.com/");
	driver.manage().window().maximize();
	System.out.println("Title is.." + driver.getTitle());
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
	Thread.sleep(3000);
	
	js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
	
	Thread.sleep(3000);
	
	List<WebElement> h3Text = driver.findElements(By.xpath("//div[@class='break-words h-10 w-full']/h3"));
	List<WebElement> price = driver.findElements(By.xpath("//span[@class='Label-sc-15v1nk5-0 Pricing___StyledLabel-sc-pldi2d-1 gJxZPQ AypOi']"));
	WriteExcel wr = new WriteExcel(filePath);
	
	HashMap<String, String> hMap = new HashMap<String, String>();
	
	for(int i=0;i<h3Text.size();i++) {
		
		String Texth3 = h3Text.get(i).getText();
		String priceVal = price.get(i).getText();

		wr.writeExcel(i, 0, Texth3);
		wr.writeExcel(i, 1, priceVal);
		
		
		}
	
	}

}

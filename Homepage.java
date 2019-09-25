package UserInterface;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Homepage{
	
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[@class='dropdown-toggle'][contains(text(),'Car & Vehicle')]")
	@CacheLookup
		WebElement clickCV;
	
	@FindBy(how=How.XPATH,using="//a[@class='hyperlink hyperlink--tertiary hyperlink--tertiary-kohl'][contains(text(),'Compulsory Third Party (CTP)')]")
	@CacheLookup
		WebElement clickCTP;
	
	public void performMenuCount() {
		System.out.println("Homepage Initiated");
		List<WebElement> home_menu=driver.findElements(By.xpath("//a[contains(@data-position, 'Primary Navigation')]"));
        System.out.println("Number of links in the menu:"+home_menu.size());  
	}
	
	public void clickCarnVehicle(){
		try {
			Thread.sleep(5000);
			clickCV.click();
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCompulsory() {
		try {
			Thread.sleep(5000);
			clickCTP.click();
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

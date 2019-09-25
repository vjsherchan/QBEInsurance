package UserInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RenewGreenSlip {

	WebDriver driver;
	public RenewGreenSlip(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Renew your Green Slip')]")
	@CacheLookup
		WebElement renewGS;
	/*
	public void textPresent() {
		String currentURL = driver.getCurrentUrl();
		  	driver.get(currentURL);
		   if(driver.getPageSource().contains("Compulsory Third Party NSW")){
			   System.out.println("Text is present");
		   }
		   else{
			   System.out.println("Text is absent");
		   }
	}
	
	public void titleCheck() {
		String expectedTitle="QBE Insurance Group - NSW Green Slips";
		   if(driver.getTitle().equals(expectedTitle)) {
			   System.out.println("Title test is successful");
		   }
		   else {
			   System.out.println("Title test is unsucessful");
		   }
	}
	*/
	public void Renew() {
		try {
			Thread.sleep(5000);
			renewGS.click();
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

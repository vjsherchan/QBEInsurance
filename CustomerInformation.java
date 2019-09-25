package UserInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerInformation {

	WebDriver driver;
	public CustomerInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Individual / sole trader')]//input[@name='customertype']")
	@CacheLookup
		WebElement ctype;
	
	@FindBy(how=How.XPATH,using="//div[2]/div[2]/qbe-answer/div/label")
	@CacheLookup
		WebElement asdf;
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'No')]//input[@name='tax']")
	@CacheLookup
		WebElement tax;
	
	@FindBy(how=How.NAME,using="dob")
	@CacheLookup
		WebElement dob;
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'No')]//input[@name='underage']")
	@CacheLookup
		WebElement underage;
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Yes')]//input[@name='licence']")
	@CacheLookup
		WebElement license;
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'None')]//input[@name='demerit']")
	@CacheLookup
		WebElement demerit;
	
	@FindBy(how=How.XPATH,using="//button[@id='button_forward']")
	@CacheLookup
		WebElement forward;
	
	public void cusInfo(String date) {
		try {
			Thread.sleep(5000);
			ctype.click();
			Thread.sleep(5000);
			asdf.click();
			Thread.sleep(5000);
			tax.click();
			Thread.sleep(5000);
			dob.sendKeys(date);
			Thread.sleep(5000);
			underage.click();
			Thread.sleep(5000);
			license.click();
			Thread.sleep(5000);
			demerit.click();
			Thread.sleep(5000);
			forward.click();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button_forward"))) != null) {
			System.out.println("All fields are populated");
		}
		else {
			System.out.println("All fields are not populated");
		}
		
	}
}

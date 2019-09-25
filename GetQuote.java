package UserInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GetQuote {

	WebDriver driver;
		
	public GetQuote(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@id='defaultOption']")
	@CacheLookup
		WebElement billingandplate;
	
	@FindBy(how=How.XPATH,using="//div[@class='hidden-xs']//div[2]//label[1]//input[1]")
	@CacheLookup
		WebElement othernumbers;
	
	@FindBy(how=How.XPATH,using="//button[@id='button_get-quote']")
	@CacheLookup
		WebElement getQuote;
	
	public void getQ() {
		getQuote.click();
	}
}

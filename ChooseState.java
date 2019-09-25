package UserInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ChooseState {

	WebDriver driver;
		
	public ChooseState(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how=How.XPATH,using="//div[@class='c-columnContent container']//div[1]//div[2]//a[1]")
	@CacheLookup
		WebElement chooseNSW;
	
	public void choosestate() {
		try {
			Thread.sleep(5000);
			chooseNSW.click();
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

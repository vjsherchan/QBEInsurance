package UserInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InsuranceCost {
	WebDriver driver;
	public InsuranceCost(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//button[@id='button_forward']")
	@CacheLookup
		WebElement forward;
	
	@FindBy(how=How.CSS,using="div.container:nth-child(6) div.qbe-content:nth-child(6) div.row div.col-sm-5 span.qbe-insert-offer-box div.panel.panel-default.panel-standout div.panel-body:nth-child(1) div.visible-md-block.visible-lg-block > span:nth-child(1)")
	@CacheLookup
		WebElement insuranceCost;
	
	public void finish() {
		System.out.println("The insurance cost for the given parameter is:"+insuranceCost.getText());
		forward.click();
	}


}

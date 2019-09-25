package UserInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnonymousQuote {

	WebDriver driver;
	public AnonymousQuote(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//div[3]//label[1]//div[1]")
	@CacheLookup
		WebElement clickAQ;
	
	@FindBy(how=How.XPATH,using="//input[@id='form-3_start_date']")
	@CacheLookup
		WebElement insurDate;
	
	@FindBy(how=How.XPATH,using="//a[@class='ui-state-default ui-state-active']")
	@CacheLookup
		WebElement insurDa;
	
	//@FindBy(how=How.CSS,using="#btn_continue")
	//@CacheLookup
	//	WebElement clickContinue;

	public void clickAnonymous() {
		clickAQ.click();
	}
	
	public void selectType(){
	    Select vehicle_type= new Select (driver.findElement(By.xpath("//form[@id='form-3']//select[@id='rms_vehicle_origin']")));
	    vehicle_type.selectByVisibleText("Current");
	}

	public void insuranceDate(String inDate){
		try {
			Thread.sleep(5000);
			insurDate.sendKeys(inDate);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement insurDa= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all:nth-child(7) table.ui-datepicker-calendar tbody:nth-child(2) tr:nth-child(5) td.ui-datepicker-days-cell-over.ui-datepicker-current-day:nth-child(2) > a.ui-state-default.ui-state-active")));
			insurDa.click();
			driver.switchTo().defaultContent();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void Conti() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement clickContinue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='form-3']//button[@id='btn_continue']")));
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(5000);
			clickContinue.click();
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

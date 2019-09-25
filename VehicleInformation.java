package UserInterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VehicleInformation {

	WebDriver driver;
	public VehicleInformation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"a1\"]")
	@CacheLookup
		WebElement year;
	
	@FindBy(how=How.XPATH,using="//button[@id='button_forward']")
	@CacheLookup
		WebElement forward;

    public void vehicleInfo(String date, String mk, String sh, String us, String sub) { 
    	
    	try {
			Thread.sleep(5000);
			year.sendKeys(date);
			Thread.sleep(5000);
			Select make= new Select (driver.findElement(By.xpath("//*[@id=\"a2\"]")));
			make.selectByVisibleText(mk);
			Thread.sleep(5000);
		    Select shape= new Select(driver.findElement(By.xpath("//*[@id=\"a3\"]")));
		    shape.selectByVisibleText(sh);
			Thread.sleep(5000);
		    Select usage= new Select(driver.findElement(By.xpath("//*[@id=\"a4\"]")));
		    usage.selectByVisibleText(us);
			Thread.sleep(5000);
		    Select suburb= new Select(driver.findElement(By.xpath("//*[@id=\"a5\"]")));
		    suburb.selectByVisibleText(sub);
			Thread.sleep(5000);
		    forward.click();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	/*	
    public void excelVehicle() {
	   	Xls_Reader reader=new Xls_Reader("C:\\Users\\798008\\eclipse-workspace\\Cucumber_Maven_Selenium_PageObjectFactory\\ExcelFile\\demo.xlsx");
	   	int rowCount=reader.getRowCount("sheet1");
	   	for (int rownum=2; rownum<=rowCount; rownum++) {
	   		String date=reader.getCellData("sheet1", "Year", rownum);
			year.sendKeys(date);
	   		String mk=reader.getCellData("sheet1", "Make", rownum);
			Select make= new Select (driver.findElement(By.xpath("//*[@id=\"a2\"]")));
			make.selectByVisibleText(mk);
	   		String sh=reader.getCellData("sheet1", "Shape", rownum);
		    Select shape= new Select(driver.findElement(By.xpath("//*[@id=\"a3\"]")));
		    shape.selectByVisibleText(sh);
	   		String us=reader.getCellData("sheet1", "Usage", rownum);
		    Select usage= new Select(driver.findElement(By.xpath("//*[@id=\"a4\"]")));
		    usage.selectByVisibleText(us);
	   		String sub=reader.getCellData("sheet1", "Suburb", rownum);
	   		Select suburb= new Select(driver.findElement(By.xpath("//*[@id=\"a5\"]")));
		    suburb.selectByVisibleText(sub);
		    forward.click();
	   	}
    }
	*/
    
    
}

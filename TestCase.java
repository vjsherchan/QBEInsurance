package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Excel_Utility.ExcelTableToDataTable;
import Excel_Utility.Xls_Reader;
import UserInterface.AnonymousQuote;
import UserInterface.ChooseState;
import UserInterface.CustomerInformation;
import UserInterface.GetQuote;
import UserInterface.Homepage;
import UserInterface.InsuranceCost;
import UserInterface.RenewGreenSlip;
import UserInterface.VehicleInformation;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TestCase{

	WebDriver driver;
	
	@Given("^user is on homepage$")
	public void user_is_on_homepage(){
		System.setProperty("webdriver.chrome.driver","C:\\\\New folder\\\\softwares to be installed\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.qbe.com/au");
		Homepage home = new Homepage(driver);
		home.performMenuCount();
	}

	
	@Then("^user clicks on Car & Vehicle$")
	public void user_clicks_on_Car_Vehicle(){
	    Homepage home=new Homepage(driver);
	    home.clickCarnVehicle();
	   	}

	@Then("^user clicks on Compulsory Third Party$")
	public void user_clicks_on_Compulsory_Third_Party(){
		Homepage home=new Homepage(driver);
		home.clickCompulsory();
	}

	@Then("^user choose State NSW and clicks on Find out more$")
	public void user_choose_State_NSW_and_clicks_on_Find_out_more(){
	    ChooseState state=new ChooseState(driver);
	    state.choosestate();
	}

	@Then("^user clicks on Renew your green slip$")
	public void user_clicks_on_Renew_your_green_slip(){
	   RenewGreenSlip renew=new RenewGreenSlip(driver);
	   renew.Renew();
	}

	@Then("^user clicks on Get a green slip quote$")
	public void user_clicks_on_Get_a_green_slip_quote(){
		String currentURL = driver.getCurrentUrl();
		driver.get(currentURL);
		if(driver.getPageSource().contains("Compulsory Third Party NSW")){
		   System.out.println("Text is present");
		}
		else{
		   System.out.println("Text is absent");
		}
		String expectedTitle="QBE Insurance Group - NSW Green Slips";
		if(driver.getTitle().equals(expectedTitle)) {
		   System.out.println("Title test is successful");
		}
		else {
		   System.out.println("Title test is unsucessful");
		}
		GetQuote get=new GetQuote(driver);
		get.getQ();
	}

	@Then("^user selects an Anonymous Quote button$")
	public void user_selects_an_Anonymous_Quote_button(){
		AnonymousQuote anon=new AnonymousQuote(driver);
		anon.clickAnonymous();
	}

	@Then("^user selects Is the Vehicle as current from the drop down$")
	public void user_selects_Is_the_Vehicle_as_current_from_the_drop_down(){
		AnonymousQuote anon=new AnonymousQuote(driver);
		anon.selectType();
	}

	@Then("^user inputs future date as Insurance Start date$")
	public void user_inputs_future_date_as_Insurance_Start_date(){
		AnonymousQuote anon=new AnonymousQuote(driver);
		anon.insuranceDate("28/10/2019");
	}

	@Then("^user clicks Continue$")
	public void user_clicks_Continue(){
		AnonymousQuote anon=new AnonymousQuote(driver);
		anon.Conti();
	}
	
	@Then("^user fills in \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\" and clicks continue$")
	public void user_fills_in_vehicle_details_page_and_continue(String date, String mk, String sh, String us, String sub){
	   VehicleInformation info=new VehicleInformation(driver);
	   info.vehicleInfo(date,mk,sh,us,sub);
	}
	
	@Then("^user clicks on Get a green slip quote anddetails with data in excel at \"([^\"]*)\"$")
	public void user_clicks_on_Get_a_green_slip_quote_anddetails_with_data_in_excel_at(@Transform(ExcelTableToDataTable.class) DataTable table) throws Throwable {
		Xls_Reader reader=new Xls_Reader("C:\\Users\\798008\\eclipse-workspace\\Cucumber_Maven_Selenium_PageObjectFactory\\ExcelFile\\demo.xlsx");
		int rowCount=reader.getRowCount("sheet1");
		for (int rownum=2; rownum<=rowCount; rownum++) {
			GetQuote get=new GetQuote(driver);
			get.getQ();
			AnonymousQuote anon=new AnonymousQuote(driver);
			anon.clickAnonymous();
			AnonymousQuote anon1=new AnonymousQuote(driver);
			anon1.selectType();
			AnonymousQuote anon2=new AnonymousQuote(driver);
			anon2.insuranceDate("28/10/2019");
			AnonymousQuote anon3=new AnonymousQuote(driver);
			anon3.Conti();
			VehicleInformation info=new VehicleInformation(driver);
			String date2=reader.getCellData("sheet1", "Year", rownum);
			String make2=reader.getCellData("sheet1", "Make", rownum);
			String shape2=reader.getCellData("sheet1", "Shape", rownum);
			String usage2=reader.getCellData("sheet1", "Usage", rownum);
			String suburb2=reader.getCellData("sheet1", "Suburb", rownum);
			info.vehicleInfo(date2, make2, shape2, usage2, suburb2);
			CustomerInformation cusInfo= new CustomerInformation(driver);
			cusInfo.cusInfo("22/11/1989");
			InsuranceCost insCost=new InsuranceCost(driver);
			insCost.finish();
				
	}
	
	
		/*
	@Then("^user fills in vehicle details with data in excel at \"([^\"]*)\" and continues$")
	public void user_fills_in_vehicle_details_with_data_in_excel_at_and_continues(@Transform(ExcelTableToDataTable.class) DataTable table){
		for (Map<String, String> data: table.asMaps(String.class, String.class)) {
			VehicleInformation info=new VehicleInformation(driver);
			info.vehicleInfo(data.get("Year"), data.get("Make"), data.get("Shape"), data.get("Usage"), data.get("Suburb"));
			CustomerInformation cusInfo= new CustomerInformation(driver);
			cusInfo.cusInfo("22/11/1989");
			InsuranceCost insCost=new InsuranceCost(driver);
			insCost.
			
		}
		//List<String> dataList=table.asList(String.class);
		/*
		Xls_Reader reader=new Xls_Reader("C:\\Users\\798008\\eclipse-workspace\\Cucumber_Maven_Selenium_PageObjectFactory\\ExcelFile\\demo.xlsx");
		int rowCount=reader.getRowCount("sheet1");
		for (int rownum=2; rownum<=rowCount; rownum++) {
			String date2=reader.getCellData("sheet1", "Year", rownum);
			String make2=reader.getCellData("sheet1", "Make", rownum);
			String shape2=reader.getCellData("sheet1", "Shape", rownum);
			String usage2=reader.getCellData("sheet1", "Usage", rownum);
			String suburb2=reader.getCellData("sheet1", "Suburb", rownum);
			info.vehicleInfo(date2, make2, shape2, usage2, suburb2);
		}
		*/
	}
	
	@Then("^user fills in personal information$")
	public void user_fills_in_personal_information(){
		CustomerInformation custinfo=new CustomerInformation(driver);
		custinfo.cusInfo("22/11/1990");
	  
	}
	
	
}

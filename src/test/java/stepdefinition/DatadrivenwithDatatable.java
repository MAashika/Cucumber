package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatadrivenwithDatatable {
	 ChromeDriver obj;
	@Given("User Navigates to the Login page")
	public void user_navigates_to_the_login_page() {
		WebDriverManager.chromedriver().browserVersion("149").setup();
		obj=new ChromeDriver();
		obj.get("https://dev.inteltechvisionpos.com/administrator/login");
		
	}
	@When("the User Enter the Valid")
	public void the_user_enter_the_valid(DataTable dataTable) {
		 List<String> data = dataTable.asList();
		String username=data.get(0);
		String password=data.get(1);

		obj.findElement(By.id("username")).sendKeys("admin");
		obj.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/form/div[2]/div/input")).sendKeys("admin123");
	}
	@And("Click on the Save Button")
	public void click_on_the_save_button() {
		obj.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/form/div[3]/button")).click();
	}
	@Then("the User can be Login to the Dashboard")
	public void the_user_can_be_login_to_the_dashboard() throws InterruptedException {
		Thread.sleep(2000);
	    obj.manage().window().maximize();
	}



}

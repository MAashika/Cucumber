package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LoginUser {
   ChromeDriver obj;
	@Given("User Navigates to the Application Login page")
	public void user_navigates_to_the_application_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().browserVersion("149").setup();
		obj=new ChromeDriver();
		obj.get("https://dev.inteltechvisionpos.com/administrator/login");
		
	    
	}
	@When("the User Enter the Username")
	public void the_user_enter_the_username() {
	    // Write code here that turns the phrase above into concrete actions
		obj.findElement(By.id("username")).sendKeys("admin");
	    
	}
	@When("the User Enter the Password")
	public void the_user_enter_the_password() {
	    // Write code here that turns the phrase above into concrete actions
		obj.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/form/div[2]/div/input")).sendKeys("admin123");
	   
	}
	@And("Click Save Button")
	public void click_save_button() {
	    // Write code here that turns the phrase above into concrete actions
		obj.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/form/div[3]/button")).click();
	    
	}
	@Then("the User can be Login to the Dashboard Successfully")
	public void the_user_can_be_login_to_the_dashboard_successfully() throws InterruptedException {
	    Thread.sleep(2000);
	    obj.manage().window().maximize();
	    
	}

}

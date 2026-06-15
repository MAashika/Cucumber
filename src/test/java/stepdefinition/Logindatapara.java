package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Logindatapara {
	ChromeDriver obj;
	@Given("User Navigates to User Creation page")
	public void user_navigates_to_user_creation_page() throws InterruptedException {
		WebDriverManager.chromedriver().browserVersion("149").setup();
		obj=new ChromeDriver();
		obj.get("https://dev.inteltechvisionpos.com/administrator/login");
		obj.findElement(By.id("username")).sendKeys("admin");
		obj.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/form/div[2]/div/input")).sendKeys("admin123");
		obj.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("/html/body/main/div[5]/div[1]/button")).click();
		obj.findElement(By.xpath("/html/body/main/div[5]/div[1]/div/div[2]/a[2]")).click();
		Thread.sleep(2000);
		obj.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[2]/div/div/div/div[1]/div/div/a")).click();
		obj.manage().window().maximize();
		
		
	}
	@When("the User Enter the {string} and {string} and {string} and {string} and {int} and {string} and {string}")
	public void the_user_enter_the_and_and_and_and_and_and(String string, String string2, String string3, String string4, Integer int1, String string5, String string6) throws InterruptedException {
	    obj.findElement(By.id("first_name_en")).sendKeys(string);
	    obj.findElement(By.id("last_name_en")).sendKeys(string2);
	    Thread.sleep(2000);
	    WebElement dropdown = obj.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[2]/div/div/div/form/div[2]/div[5]/div/div/div/span/span[1]/span/span[1]"));
		Actions actions = new Actions(obj);
		actions.moveToElement(dropdown).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

	    obj.findElement(By.id("username")).sendKeys(string3);
	    obj.findElement(By.id("email")).sendKeys(string4);
	    obj.findElement(By.id("number")).sendKeys(String.valueOf(int1));
	    WebElement Gender=obj.findElement(By.id("gender"));
	    Select sel=new Select(Gender);
	    sel.selectByIndex(1);
	    Thread.sleep(2000);
	    obj.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[2]/div/div/div/form/div[2]/div[12]/div/div/input")).sendKeys(string5);
	    obj.findElement(By.id("password2")).sendKeys(string6);
	}
	@And("Click the Save Button")
	public void Click__the_Save_Button(){
		WebDriverWait wait = new WebDriverWait(obj, Duration.ofSeconds(10));

		WebElement saveBtn = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//button[contains(text(),'Save')]")));

		((JavascriptExecutor)obj)
		        .executeScript("arguments[0].scrollIntoView(true);", saveBtn);

		saveBtn.click();
	}
	@Then("the New User can be Created successfully")
	public void the_new_user_can_be_created_successfully() {
	    
	  obj.close();
	}




}

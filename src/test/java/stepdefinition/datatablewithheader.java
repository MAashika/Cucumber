package stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class datatablewithheader {
	ChromeDriver obj;
	@Given("User go to the Login page")
	public void user_go_to_the_login_page() {
		WebDriverManager.chromedriver().browserVersion("149").setup();
		obj=new ChromeDriver();
		obj.get("https://dev.inteltechvisionpos.com/administrator/login");
	}
	@When("the User Enter the Invalid Credentials")
	public void the_user_enter_the_invalid_credentials(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		 List<Map<String, String>> data =
		            dataTable.asMaps(String.class, String.class);

		    String username = data.get(0).get("Username");
		    String password = data.get(0).get("Password");

	
		

		obj.findElement(By.id("username")).sendKeys(username);
		obj.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/form/div[2]/div/input")).sendKeys(password);
	    
	}
	@And("Click onto the Save Button")
	public void Click_onto_the_Save_Button() {
		obj.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/form/div[3]/button")).click();
		
	}



}

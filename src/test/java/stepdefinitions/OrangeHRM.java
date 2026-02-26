package stepdefinitions;



import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRM
{
	public static WebDriver driver;
	String empid;
	String ename;
	 
    
	@Given("i open browser with url {string}")
	public void i_open_browser_with_url(String url) 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");		
		driver = new ChromeDriver();		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		driver.get(url); 	    
	}
	
	@Then("i should see login page")
	public void i_should_see_login_page() 
	{
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
		{
			System.out.println("System displayed Login Page");
		}else
		{
			System.out.println("System not displayed Login Page");
		} 
	}
	
	@When("i enter username as {string}")
	public void i_enter_username_as(String uname) 
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uname); 
	}
	
	@When("i enter password as {string}")
	public void i_enter_password_as(String pword) 
	{
		driver.findElement(By.id("txtPassword")).sendKeys(pword); 
	}
	
	@When("i click login")
	public void i_click_login() 
	{
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Then("i should see admin module")
	public void i_should_see_admin_module() 
	{
		 if(driver.findElement(By.linkText("Admin")).isDisplayed())
		 {
		 	System.out.println("System displayed Admin Module");
		 } 
	}
	
	@When("i click logout")
	public void i_click_logout() 
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}
	
	@When("i close browser")
	public void i_close_browser() 
	{
		driver.close();
	}
	@Then("i should see error message")
	public void iShouldSeeErrorMessage(){
	String errmsg;
	    errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
	    if(errmsg.contains("invalid") || errmsg.contains("empty"))
	    {
	    		System.out.println("System displayed appropriate Error message for invalid credentials");
	    }else
	    {
	    		System.out.println("System displayed approaite errie msg");

	}
	
	}	
	@When("i goto add employee page")
	public void i_goto_add_employee_page() 
	{
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click(); 
	}
	
	@When("i enter firstname as {string}")
	public void i_enter_firstname_as(String fname) 
	{
		driver.findElement(By.id("firstName")).sendKeys(fname);
	}
	
	@When("i enter lastname as {string}")
	public void i_enter_lastname_as(String lname) 
	{
		driver.findElement(By.id("lastName")).sendKeys(lname); 
	}
	
	@When("i click save")
	public void i_click_save() 
	{
		empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		
	}
	
	@Then("i should see registered employee in employee list")
	public void i_should_see_registered_employee_in_employee_list() 
	{
		 driver.findElement(By.linkText("Employee List")).click();
		 driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		 driver.findElement(By.id("searchBtn")).click();
		    
		    WebElement emptable = driver.findElement(By.id("resultTable"));
		    List<WebElement> rows = emptable.findElements(By.tagName("tr"));
		    
		    for(int i=1;i<rows.size();i++)
		    {
		    	List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
		    	if(cols.get(1).getText().equals(empid))
		    	{
		    		System.out.println("New Employee Registered Successfully");
		    		break;
		    	}
		    } 
	}
	
	@When("i goto Add users Page")
	public void i_goto_add_users_page() {
	  driver.findElement(By.linkText("Admin")).click();
	  driver.findElement(By.linkText("User Management")).click();
	  driver.findElement(By.linkText("Users")).click();
	 driver.findElement(By.id("btnAdd")).click();
	}
	@When("i select user role as {string}")
	public void i_select_user_role_as(String role) {
	    Select userRole = new Select(driver.findElement(By.id("systemUser_userType")));
	    userRole.selectByVisibleText(role);
	}

	@When("i enter empname as {string}")
	public void i_enter_empname_as(String empname) {
		
		driver.findElement(By.xpath("//input[contains(@id,'employeeName')]")).sendKeys(empname);
		
	}
	
	@When("i enter system username as {string}")
	public void i_enter_system_username_as(String susername) {
		 ename = susername;  
	  driver.findElement(By.id("systemUser_userName")).sendKeys(susername);
	}
	@When("i select user status as {string}")
	public void i_select_user_status_as(String status) {
	    Select userStatus = new Select(driver.findElement(By.id("systemUser_status")));
	    userStatus.selectByVisibleText(status);
	}

 
	@When("i enter  system user password as {string}")
	public void i_enter_system_user_password_as(String userpassword) {
		driver.findElement(By.id("systemUser_password")).sendKeys(userpassword);
	}

	@When("i enter system user confirm password as {string}")
	public void i_enter_system_user_confirm_password_as(String confirmpassword) throws InterruptedException {
	    driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(confirmpassword);
	    Thread.sleep(2000);
	}
	@When("i click user save")
	public void i_click_user_save() throws Throwable  {
		driver.findElement(By.name("btnSave")).click();
		Thread.sleep(5000);		
		
	}



	@Then("i should see registered user in userspage")
	public void i_should_see_registered_user_in_userspage() throws Throwable {
		 driver.findElement(By.linkText("Admin")).click();
		    driver.findElement(By.linkText("User Management")).click();
		    driver.findElement(By.linkText("Users")).click();
		  // Wait because page refreshes after save
	    Thread.sleep(3000);

	    driver.findElement(By.id("searchSystemUser_userName")).clear();
	    driver.findElement(By.id("searchSystemUser_userName")).sendKeys(ename);
	    driver.findElement(By.id("searchBtn")).click();

	    Thread.sleep(2000);

	    WebElement users_table = driver.findElement(By.id("resultTable"));
	    List<WebElement> rows = users_table.findElements(By.tagName("tr"));

	    boolean res = false;

	    for (int i = 1; i < rows.size(); i++) {
	        List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

	        if (cols.get(1).getText().equals(ename)) {
	            res = true;
	            System.out.println("User registered successfully");
	            break;
	        }
	    }

	    Assert.assertTrue(res, "User NOT found in users list");
	   
		}
	@Then(": i should see emplyoee module")
	public void i_should_see_emplyoee_module() {
		 if(driver.findElement(By.partialLinkText("Uday")).isDisplayed())
		 {
		 	System.out.println("System displayed employee Module");
		 } 
	  }
	}
	
	
	    	
	
	



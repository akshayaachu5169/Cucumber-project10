package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver wd;

	@Given("open browser as {string}")
	public void openbrowser(String browser) {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();

	}

	@When("enter url as {string}")
	public void enterurlas(String url) {
		wd.get(url);
	}

	@And("enter username as {string}")
	public void enterusername(String username) {
		wd.findElement(By.name("username")).sendKeys(username);
		;
	}

	@When("enter password as {string}")
	public void enterpassword(String password) {
		wd.findElement(By.name("password")).sendKeys(password);
	}

	@And("click login button")
	public void clickloginbutton() {
		wd.findElement(By.xpath("/html/body/main/div/div/div/div/form/div/button")).click();
	}

	@Then("verify the welcome page as {string} in header")
	public void verifythewelcomepage(String welcomemsg) {
		System.out.println(wd.getTitle() + welcomemsg);
	}

	@But("dont click remember password")
	public void dontclickrememberpassword() {
		System.out.println("---dont click remember password---");
		int i = 1 / 0;
	}

	@After
	public void tearsome(Scenario s) throws IOException {
		System.out.println("id--" + s.getId());
		System.out.println("name--" + s.getName());
		System.out.println("line--" + s.getLine());
		System.out.println("status--" + s.getStatus());
		System.out.println("url--" + s.getUri());

		if (s.isFailed()) {
			File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

			FileHandler.copy(src, new File("screenshot\\error.png"));
		}
	}

}
